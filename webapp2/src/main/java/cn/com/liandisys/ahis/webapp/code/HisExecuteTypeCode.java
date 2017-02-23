package cn.com.liandisys.ahis.webapp.code;

public enum HisExecuteTypeCode {
    QUERYDEPTINFO("01", "科室信息查询", "QueryDeptInfo"),
    QUERYDOCTORINFO("02", "医生信息查询", "QueryDoctInfo"),
    QUERYREGISTERINFO("03", "预约号源信息查询", "QueryYRegisterSource"),
    QUERYZYJLCX("04", "住院记录查询", "ZYJLCX"),
    QUERYZYFYQDCX("05", "住院费用清单查询", "ZYFYQDCX"),
    QUERYZYYJBJZF("06", "住院押金补缴支付", "ZYYJBJZF"),
	QUERY_YREGISTERRECORD("07", "预约挂号记录查询", "Query_YRegisterRecord"),
	QUERYMZDJFJLCX("08", "门诊待缴费记录查询", "MZDJFJLCX"),
	QUERYMZDJFJLMXCX("09", "门诊待缴费记录明细查询", "MZDJFJLMXCX"),
	QUERYJCJGLBCX("10", "检查结果列表查询", "JCJGLBCX"),
	QUERYJYBGLBCX("11", "检验报告列表查询", "JYBGLBCX"),
	QUERYTJBGLBCX("12", "体检报告列表查询", "TJBGLBCX"),
	QUERYJCJGXQCX("13", "检查结果详情查询", "JCJGXQCX"),
	QUERYJYBGXQCX("14", "检验报告详情查询", "JYBGXQCX"),
	QUERYTJBGXQCX("15", "体检报告详情查询", "TJBGXQCX"),
	QUERYTJXMXQCX("16", "体检项目详情查询", "TJXMXQCX"),
	QUERYCRCEATEPATIENTINFO("17", "首患建档", "CreatPatientInfo"),
	QUERYAPPOINT("18", "预约挂号", "Lock_YYRegister"),
	QUERYAPPOINTCANCEL("19", "取消预约", "UnLock_YYRegeister"),
	QUERYAPPOINTPAY("20", "预约支付", "Pay_YYRegister"),
	QUERYMZJFDDZF("21","门诊缴费","MZJFDDZF");
    private String _code;
    private String _hisExecuteTypeName;
    private String _hisExecuteUri;

    HisExecuteTypeCode(String code, String hisExecuteTypeName, String hisExecuteUri) {
        this._code = code;
        this._hisExecuteTypeName = hisExecuteTypeName;
        this._hisExecuteUri = hisExecuteUri;
    }

    public String code() {
        return this._code;
    }

    public String hisExecuteTypeName() {
        return this._hisExecuteTypeName;
    }

    public String hisExecuteUri() {
        return this._hisExecuteUri;
    }
}
