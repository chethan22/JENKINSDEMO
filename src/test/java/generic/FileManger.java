package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileManger {

	Properties pro;

	public FileManger() {

		try {
			FileInputStream fis = new FileInputStream("F:\\SELNIUM 2020 IDE\\Testq\\env.properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("property file not found");
		}
	}

	public String getQatUrl() {
		String url = pro.getProperty("qat");
		if (url != null) {
			return url;
		} else {

			throw new RuntimeException("qat url not found");
		}
	}

	public String getPreProduction() {
		String url = pro.getProperty("preprod");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("preProdction url not found");
		}
	}

	public String getproductionUrl() {
		String url = pro.getProperty("production");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("production url not found");
		}
	}

	public long getimplicitlyWait() {
		String key = pro.getProperty("implicitlyWait");
		long val = Long.parseLong(key);
		return val;
	}

}
