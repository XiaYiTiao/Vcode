package practice;

import java.util.ArrayList;
import java.util.Stack;

public class TString {
	public String replaceSpace(StringBuffer str) {
		StringBuffer sb = new StringBuffer();
		String s = str.toString();
		for (int i = 0; i < str.length(); i++) {
			if (s.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<Integer> li = new ArrayList<Integer>();
		while (!s.empty()) {
			li.add(s.pop());
		}
		return li;
	}

	public ListNode ReverseList(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = null;
		ListNode p3 = null;
		if (p1 != null) {
			p2 = p1.next;
		}
		if (p2 != null) {
			p3 = p2.next;
		}
		while (p3 != null) {
			if (p1 == head) {
				p1.next = null;
			}
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
		}
		if (p2 != null) {
			p2.next = p1;
			head = p2;
		} else {
			head = p1;
		}
		return head;

	}

	public void start() {
		ListNode head = new ListNode(1);
		ReverseList(head);

	}

	public boolean Find(int target, int[][] array) {
		// 两次二分查找即可 横--列
		int column = array[0].length;
		int rows = array.length;
		boolean flag = false;
		if (column != 0 && rows != 0) {
			int left = 0;
			int right = column - 1;
			int med = column / 2;
			// 第一次找大致范围 一定要接近或等于target才行
			while (left < right) {

				if (array[0][med] < target) {
					System.out.println(array[0][med] + "-" + target);
					left = med + 1;
				} else if (array[0][med] > target) {
					System.out.println(array[0][med] + "--" + target);
					right = med - 1;
				} else if (array[0][med] == target) {
					flag = true;
					break;
				}
				med = (left + right) / 2;
			}
			System.out.println(med);
			// 第二次精确查找
			int mleft = 0;
			int mright = rows - 1;
			int mmed = rows / 2;
			while (mleft < mright) {

				if (array[mmed][med] < target) {
					System.out.println(array[mmed][med] + "-" + target);
					mleft = mmed + 1;
				} else if (array[mmed][med] > target) {
					System.out.println(array[mmed][med] + "--" + target);
					mright = mmed - 1;
				} else if (array[mmed][med] == target) {
					flag = true;
					break;
				}
				mmed = (mleft + mright) / 2;
			}
			System.out.println(mmed + " " + med);
			if (array[mmed][med] == target) {
				flag = true;
			} else {
				// 回溯
				System.out.println();
				for (int i = med; i >= 0; i--) {
					int mleft1 = 0;
					int mright1 = rows - 1;
					int mmed1 = rows / 2;
					while (mleft1 < mright1) {

						if (array[mmed1][i] < target) {
							System.out.println(array[mmed1][i] + "-" + target);
							mleft1 = mmed1 + 1;
						} else if (array[mmed1][i] > target) {
							System.out.println(array[mmed1][i] + "--" + target);
							mright1 = mmed1 - 1;
						} else if (array[mmed1][i] == target) {
							flag = true;
							break;
						}
						mmed1 = (mleft1 + mright1) / 2;
					}
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// // System.out.println(new TString().replaceSpace(new StringBuffer("
		// // ")));
		// // int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, {
		// 6,
		// // 8, 11, 15 } };
		// // int[][] a = { {} };
		// // int[][] b={{1}};
		// // System.out.println(b.length + "--" + b[0].length);
		// int[][] a = {
		// { 1, 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 27, 30, 32, 35, 36,
		// 38, 39, 42, 44, 46, 47, 48, 49, 51,
		// 54, 55, 56 },
		// { 3, 4, 6, 8, 11, 13, 15, 18, 19, 20, 23, 25, 27, 29, 33, 36, 38, 41,
		// 42, 45, 48, 50, 53, 54, 57, 60,
		// 63, 65, 66, 67 },
		// { 5, 7, 8, 11, 14, 15, 17, 19, 21, 23, 24, 28, 31, 33, 36, 39, 41,
		// 44, 47, 49, 52, 53, 56, 57, 60, 63,
		// 66, 68, 71, 72 },
		// { 7, 10, 13, 14, 17, 19, 22, 25, 26, 27, 30, 32, 34, 37, 39, 42, 44,
		// 46, 50, 53, 55, 56, 59, 61, 64, 66,
		// 69, 72, 74, 76 },
		// { 8, 12, 16, 17, 20, 21, 23, 26, 29, 31, 33, 35, 37, 40, 42, 45, 48,
		// 49, 52, 55, 58, 59, 61, 63, 67, 69,
		// 70, 74, 76, 79 },
		// { 10, 15, 18, 20, 22, 24, 27, 30, 32, 33, 36, 38, 39, 41, 45, 47, 50,
		// 53, 56, 58, 61, 64, 65, 68, 69,
		// 71, 73, 76, 79, 82 },
		// { 13, 17, 20, 23, 24, 26, 28, 31, 34, 36, 38, 41, 42, 43, 48, 50, 53,
		// 56, 58, 61, 64, 67, 68, 71, 73,
		// 74, 75, 78, 81, 84 },
		// { 15, 19, 22, 24, 26, 28, 31, 34, 35, 38, 41, 44, 45, 46, 49, 51, 56,
		// 59, 61, 64, 67, 69, 71, 73, 76,
		// 78, 79, 82, 85, 87 },
		// { 17, 20, 23, 26, 29, 30, 32, 37, 40, 42, 43, 47, 50, 53, 55, 56, 58,
		// 62, 64, 66, 69, 72, 75, 78, 80,
		// 81, 83, 86, 88, 90 },
		// { 18, 21, 25, 28, 30, 32, 35, 38, 42, 43, 44, 49, 51, 55, 58, 59, 61,
		// 65, 68, 71, 73, 74, 77, 79, 82,
		// 85, 88, 89, 91, 93 },
		// { 20, 23, 28, 29, 33, 36, 37, 40, 43, 45, 47, 52, 55, 58, 60, 62, 63,
		// 66, 70, 74, 76, 77, 79, 81, 85,
		// 88, 89, 91, 93, 94 },
		// { 23, 25, 31, 33, 35, 39, 42, 43, 44, 46, 50, 53, 56, 61, 62, 65, 68,
		// 69, 72, 75, 78, 81, 82, 83, 88,
		// 91, 92, 93, 96, 99 },
		// { 26, 27, 33, 34, 38, 40, 45, 48, 51, 53, 55, 56, 58, 64, 66, 69, 72,
		// 75, 77, 80, 82, 84, 87, 88, 90,
		// 93, 94, 95, 99, 101 },
		// { 29, 30, 36, 38, 40, 42, 47, 50, 53, 56, 57, 59, 62, 65, 68, 71, 73,
		// 77, 79, 83, 84, 86, 88, 91, 93,
		// 96, 99, 100, 102, 103 },
		// { 32, 33, 39, 42, 44, 46, 49, 53, 56, 59, 62, 65, 68, 71, 72, 75, 77,
		// 78, 80, 85, 87, 90, 92, 94, 96,
		// 99, 101, 103, 105, 107 },
		// { 35, 37, 42, 43, 46, 48, 51, 55, 59, 61, 65, 67, 71, 74, 76, 78, 81,
		// 82, 84, 86, 90, 92, 95, 96, 99,
		// 102, 103, 106, 107, 109 },
		// { 36, 39, 43, 46, 49, 50, 53, 58, 62, 65, 67, 70, 73, 76, 77, 79, 84,
		// 87, 88, 90, 93, 96, 99, 102, 103,
		// 106, 108, 111, 112, 115 },
		// { 38, 42, 45, 47, 52, 55, 57, 60, 64, 66, 69, 72, 75, 78, 80, 82, 87,
		// 89, 91, 92, 94, 99, 100, 103, 105,
		// 107, 111, 112, 115, 118 },
		// { 39, 44, 48, 49, 55, 57, 60, 63, 66, 69, 72, 75, 78, 80, 82, 85, 89,
		// 92, 94, 95, 98, 101, 102, 105,
		// 108, 111, 112, 115, 116, 120 },
		// { 40, 47, 49, 52, 56, 59, 63, 64, 68, 71, 75, 78, 80, 83, 85, 88, 91,
		// 94, 97, 99, 101, 104, 105, 108,
		// 110, 112, 115, 118, 120, 123 },
		// { 42, 50, 53, 55, 59, 62, 66, 67, 71, 73, 78, 81, 82, 86, 87, 90, 94,
		// 97, 100, 101, 104, 106, 107, 109,
		// 111, 114, 117, 120, 123, 126 },
		// { 43, 51, 55, 58, 62, 64, 69, 71, 74, 77, 81, 84, 86, 87, 89, 93, 96,
		// 99, 102, 103, 105, 108, 111, 112,
		// 113, 116, 120, 122, 125, 129 },
		// { 45, 54, 56, 59, 65, 67, 72, 75, 76, 79, 84, 87, 90, 92, 94, 97, 99,
		// 102, 104, 107, 108, 111, 114, 116,
		// 119, 120, 122, 124, 127, 132 },
		// { 47, 55, 59, 62, 66, 68, 74, 78, 80, 82, 85, 88, 93, 96, 99, 101,
		// 102, 105, 106, 108, 110, 113, 115,
		// 118, 120, 121, 124, 127, 130, 133 },
		// { 49, 56, 61, 65, 68, 70, 76, 81, 83, 85, 87, 91, 95, 99, 102, 103,
		// 104, 106, 108, 110, 113, 116, 118,
		// 121, 124, 127, 130, 133, 134, 137 },
		// { 51, 57, 62, 68, 71, 74, 78, 83, 86, 89, 92, 95, 97, 101, 104, 106,
		// 108, 110, 113, 114, 117, 119, 121,
		// 123, 126, 130, 132, 135, 137, 140 },
		// { 53, 59, 65, 69, 73, 75, 81, 86, 88, 92, 95, 97, 100, 103, 107, 109,
		// 111, 112, 115, 117, 120, 122, 125,
		// 126, 129, 131, 133, 138, 141, 143 },
		// { 55, 61, 67, 72, 75, 77, 82, 89, 92, 94, 97, 100, 102, 105, 108,
		// 111, 114, 115, 116, 119, 123, 125,
		// 126, 128, 131, 134, 137, 140, 144, 146 },
		// { 57, 63, 68, 74, 78, 81, 85, 90, 95, 98, 100, 101, 103, 107, 110,
		// 114, 117, 119, 120, 123, 126, 129,
		// 130, 133, 136, 138, 141, 144, 146, 149 },
		// { 58, 65, 70, 76, 81, 84, 86, 93, 98, 101, 104, 105, 107, 110, 112,
		// 115, 120, 122, 124, 126, 129, 132,
		// 135, 136, 138, 140, 142, 146, 149, 150 } };
		// System.out.println(new TString().Find(102, a));
		// System.out.println(a[1][2]);
		new TString().start();

	}
}
