package model;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private String tempStr;
	
	private String dateStr;
	
	private String[] cookieK;
	
	private String[] cookieAllow;

	public weatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

		public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

		public String getTempStr() {
			return tempStr;
		}

		public void setTempStr(String tempStr) {
			this.tempStr = tempStr;
		}
		

		public String getDateStr() {
			String date = dateStr.substring(0,10);
			return date;
		}

		public void setDateStr(String dateStr) {
			this.dateStr = dateStr;
		}

		public String[] getCookieK() {
			return cookieK;
		}

		public void setCookieK(String[] cookieK) {
			this.cookieK = cookieK;
		}

		public String[] getCookieAllow() {
			return cookieAllow;
		}

		public void setCookieAllow(String[] cookieAllow) {
			this.cookieAllow = cookieAllow;
		}
			

}
