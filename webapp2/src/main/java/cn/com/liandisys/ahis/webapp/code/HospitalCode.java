package cn.com.liandisys.ahis.webapp.code;

public enum HospitalCode {
    WX3H("0001", "无锡市第三人民医院");

    private String _code;
    private String _hospitalName;

    HospitalCode(String code, String hospitalName) {
        this._code = code;
        this._hospitalName = hospitalName;
    }

    public String code() {
        return _code;
    }

    public String hospitalName() {
        return _hospitalName;
    }
}
