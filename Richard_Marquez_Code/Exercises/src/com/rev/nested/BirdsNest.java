/*
 * Exmples of all 4 types of inner classes
 * static
 * member
 * local inner
 * anonymous
 */
package com.rev.nested;

abstract class AbsEx {
	public abstract void absMeth();
}

public class BirdsNest {
	static int staticData = 30;
	
	static class StatCl {
		void msg() {
			System.out.println("static msg");
		}
	}
	
	class MemberInner {
		void msg() { System.out.println("member inner"); }
	}
	
	public static void main(String[] args) {
		AbsEx absEx = new AbsEx() {
			public void absMeth() {
				System.out.println("abs meth");
			}
		};
		
		absEx.absMeth();
		
		BirdsNest.StatCl sc = new BirdsNest.StatCl();
		sc.msg();
		
		class LocalInner {
			void msg() { System.out.println("local inner"); }
		}
		
		LocalInner li = new LocalInner();
		li.msg();
		
		BirdsNest bn = new BirdsNest();
		BirdsNest.MemberInner mi = bn.new MemberInner();
		mi.msg();
	}
}
