package cn.com.liandisys.ahis.webapp.code;

public enum HisExecuteTypeCode {
    QUERYDEPTINFO("01", "科室信息查询", "QueryDeptInfo");
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
