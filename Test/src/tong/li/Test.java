package tong.li;

import org.bouncycastle.util.encoders.Hex;

public class Test {

	public static void main(String[] args) {
		AES aes = new AES();
	//   加解密 密钥
	  byte[] keybytes = { 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38 };
	  //String content = "{\"item\":[{\"deptDescription\":\"咽炎，鼻炎，中耳炎，耳鸣，鼻中隔偏曲\",\"deptName\":\"耳鼻喉科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0001\"},{\"deptDescription\":\"小儿咳嗽，小儿哮喘，小儿感冒，小儿腹泻\",\"deptName\":\"儿科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0002\"},{\"deptDescription\":\"风湿病，关节炎，痛风，强制性脊柱炎\",\"deptName\":\"风湿科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0003\"},{\"deptDescription\":\"肿瘤，血管病\",\"deptName\":\"放射科介入科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0004\"},{\"deptDescription\":\"月经不调，不孕不育，多囊卵巢综合症，盆腔炎，子宫肌瘤\",\"deptName\":\"妇科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0005\"},{\"deptDescription\":\"心脑血管系统疾病，脾胃病，呼吸系统及神经系统疾病，失眠，汗症，内科疑难杂症\",\"deptName\":\"高级专家诊疗科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0006\"},{\"deptDescription\":\"颈椎病,骨折，腰椎间盘，骨质增生，人工关节置换\",\"deptName\":\"骨伤科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0007\"},{\"deptDescription\":\"乙肝，肝硬化，肝炎，脂肪肝，丙肝，新生儿黄疸\",\"deptName\":\"感染科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0008\"},{\"deptDescription\":\"痔疮，肛瘘，直肠肛管疾病，肛裂，肠炎\",\"deptName\":\"肛肠科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0009\"},{\"deptDescription\":\"咳嗽，哮喘，肺结核病\",\"deptName\":\"呼吸内科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0010\"},{\"deptDescription\":\"血液微量元素检测，人体免疫\",\"deptName\":\"化验科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0011\"},{\"deptDescription\":\"脊髓损伤劳损\",\"deptName\":\"脊髓科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0012\"},{\"deptDescription\":\"心率不齐，冠心病\",\"deptName\":\"心脏科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0013\"},{\"deptDescription\":\"淋巴系统疾病，白血病\",\"deptName\":\"血液科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0014\"},{\"deptDescription\":\"胆囊炎，胃溃疡，肠炎\",\"deptName\":\"消化科\",\"deptLocation\":\"门诊楼4楼401\",\"hasChild\":0,\"parentDeptCode\":0,\"deptCode\":\"0015\"}],\"resultCode\":0,\"resultMessage\":\"查询成功\"}";
	  String content = "{}";
	  // 加密字符串
	  System.out.println("加密前的：" + content);
	  System.out.println("加密密钥：" + new String(keybytes));
	  // 加密方法
	  byte[] enc = aes.encrypt(content.getBytes(), keybytes);
	  System.out.println("加密后的内容：" + new String(Hex.encode(enc)));
	  String xxx = new String(Hex.encode(enc));
	  byte[] decxxx = aes.decrypt(Hex.decode(xxx.getBytes()), keybytes);
	  System.out.println("解密后的内容：" + new String(decxxx));
	  // 解密方法
	  byte[] dec = aes.decrypt(enc, keybytes);
	  System.out.println("解密后的内容：" + new String(dec));
	}

}
