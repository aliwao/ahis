package cn.com.liandisys.ahis.payment.form.sltf;

public class BaseResultForm extends BaseForm {

    // 处理结果编码
    private String resultcode;
    // 处理结果描述
    private String resultmsg;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultmsg() {
        return resultmsg;
    }

    public void setResultmsg(String resultmsg) {
        this.resultmsg = resultmsg;
    }

}
