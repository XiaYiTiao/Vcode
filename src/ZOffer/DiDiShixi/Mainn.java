package DiDiShixi;

import java.util.Stack;

public class Mainn {
	public static int resolve(String expr) {
		String str = expr;
		try {
			Stack s = new Stack<Integer>();
			for (int i = 0; i < str.length(); i++) {
				// System.out.println(str.charAt(i));
				if (str.charAt(i) == ' ') {
					continue;
				}
				if (str.charAt(i) != '+' && str.charAt(i) != '^'
						&& str.charAt(i) != '*') {
					s.push(Integer.valueOf(String.valueOf(str.charAt(i))));
				}
				if (str.charAt(i) == '+') {
					if (s.empty() || s.size() < 2) {
						throw new Exception("-1");
					} else {
						// System.out.println("[+]");
						int n1 = (Integer) s.pop();
						int n2 = (Integer) s.pop();
						try {
							s.push(n1 + n2);
						} catch (Exception e1) {
							return -2;
						}
					}
				}
				if (str.charAt(i) == '*') {
					if (s.empty() || s.size() < 2) {
						throw new Exception("-1");
					} else {
						// System.out.println("[*]");
						int n1 = (Integer) s.pop();
						int n2 = (Integer) s.pop();
						try {
							s.push(n1 * n2);
						} catch (Exception e1) {
							return -2;
						}
					}
				}
				if (str.charAt(i) == '^') {
					if (s.empty()) {
						throw new Exception("-1");
					} else {
						// System.out.println("[^]");
						int n1 = (Integer) s.pop();
						s.push(n1 + 1);
					}
				}

			}
			if (s.size() == 1) {
				return (Integer) s.pop();
			} else {
				return -2;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			return -1;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub

		// TODO Auto-generated constructor stub
		// Scanner sc = new Scanner(System.in);
		// String str = sc.nextLine();
		String str = "2 3  4 * ^ 5 +".trim();
		Mainn m = new Mainn();
		System.out.println(m.resolve(str));

	}
}
