package it.simone.xmlConfigurationBaseBean;

public class SpringFather {

		private Child child;
		
		public SpringFather(Child ch){
			this.child = ch;
		}
		
		public void printChildInfo(){
			this.child.printChild();
		}
}
