public class ValidateIPAddressSolution {
	private String ipType = "Neither";
	private static final String IP4SEPERATOR = "\\.";
	private static final String IP6SEPERATOR = "\\:";

	public String validIPAddress(String IP) {
		if (IP.contains("."))
			this.validateIpv4(IP);
		else if (IP.contains(":"))
			this.validateIpv6(IP);

		return this.ipType;
	}

	private void validateIpv4(String IP) {

		this.ipType = "Neither";

		if (IP.charAt(IP.length() - 1) == '.')
			return;

		String[] stringArr = IP.split(IP4SEPERATOR);
		if (stringArr == null || stringArr.length != 4)
			return;

		for (String token : stringArr) {
			if (token.length() == 0 || token.length() > 3)
				return;
			if (token.length() > 1 && token.startsWith("0"))
				return;

			int val = 0;
			for (int i = 0; i < token.length(); i++) {
				char c = token.charAt(i);
				if (c < '0' || c > '9')
					return;
				val = val * 10 + (int) (c - '0');
			}

			if (val < 0 || val > 255)
				return;
		}

		this.ipType = "IPv4";

	}

	private void validateIpv6(String IP) {
		this.ipType = "Neither";

		if (IP.charAt(IP.length() - 1) == ':')
			return;
		String[] stringArr = IP.split(IP6SEPERATOR);
		if (stringArr == null || stringArr.length != 8)
			return;

		for (String token : stringArr) {
			if (token.length() == 0 || token.length() > 4)
				return;
			int i = 0;
			while (i < token.length()) {
				char c = token.charAt(i++);
				if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) 
					return;
			}
		}

		this.ipType = "IPv6";
	}

	public static void main(String[] args) {
		ValidateIPAddressSolution solution = new ValidateIPAddressSolution();
		System.out.println(solution.validIPAddress("172.16.254.1"));
		System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(solution.validIPAddress("172.16.254.1"));
		System.out.println(solution.validIPAddress("256.256.256.256"));
	}

}
