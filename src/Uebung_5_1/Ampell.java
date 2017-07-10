package Uebung_5_1;

public class Ampell {
	private boolean g,r,y,ry;
	
	Ampell(){
		r = true;
		y = false;
		g = false;
		ry = false;
	}
	
	public boolean green(){
		if(g==true){
			System.out.println("ist grün");
			return false;
		}else{
			System.out.println("ist rot");
			y = true;
			
			return true;
		}
		
	}
	public boolean red(){
		if(r==true){
			System.out.println("ist rot");
			return false;
		}else{
			System.out.println("ist grün");
			ry = true;
			return true;
		}
	}
	public boolean yellow(){
		
		if(y==true){
			if(g==false){
				System.out.println("ist gelb");
				r = false;
				y = false;
				g = true;
			}
			return y;
		}else{
			y = true;
			return y;
		}
		
	}
	public boolean redYellow(){
		if(ry==true){
			if(r==false){
				System.out.println("ist gelbrot");
				r = true;
				ry = false;
				g = false;
			}
		}else{
			ry = true;
		}
		return ry;
	}
	public boolean blink(){
		boolean bli = true;
		r = false;
		g = false;
		y = true;
		System.out.println(bli);
		while(bli){
			if(y==true){
				y = false;
			}else{
				y = true;
			}
			System.out.println(y);
		}
		return bli;
		
	}
}
