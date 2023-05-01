package year2022.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.DatatypeConverter;

public class Application2 {

	static String finito = "";
	static int totale = 0;
	static final int Y =  2000000;
	
	

	public static void main(String[] args) {
		
		
		long xMin= 0;	
		long xMax = 0 ;
		long raggio = 0;
		//String list[][] = new String[9000000][9000000];
		long beacons = 0;
		long raggioCalcolato = 0;
		Map<Integer,String> listaDuemilioni = new TreeMap<>();
		Map<Assi,String>listaQuattrmilioni = new TreeMap<>();
		long xUno = 0;
		long xDue = 0;
		List<Coord> sensorAndBeacon = new ArrayList<>();
		Coord coord = null;
		
		try {
			long X1;long	X2; long	Y1;long 	Y2; long	R;
			X1=1555825;	X2=1498426;	Y1=18926;	Y2=85030;	R=123503;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=697941;	X2=595451;	Y1=3552290;	Y2=3788543;	R=338743;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3997971;	X2=3951198;	Y1=2461001;	Y2=2418718;	R=89056;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3818312;	X2=4823751;	Y1=282332;	Y2=1061753;	R=1784860;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2874142;	X2=3074353;	Y1=3053631;	Y2=3516891;	R=663471;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=1704479;	X2=1749091;	Y1=2132468;	Y2=2000000;	R=177080;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3904910;	X2=3951198;	Y1=2080560;	Y2=2418718;	R=384446;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=657061;	X2=595451;	Y1=3898803;	Y2=3788543;	R=171870;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3084398;	X2=3074353;	Y1=3751092;	Y2=3516891;	R=244246;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2582061;	X2=1749091;	Y1=972407;	Y2=2000000;	R=1860563;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2886721;	X2=3074353;	Y1=3971936;	Y2=3516891;	R=642677;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=303399;	X2=1010425;	Y1=548513;	Y2=986825;	R=1145338;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3426950;	X2=3951198;	Y1=2290126;	Y2=2418718;	R=652840;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3132858;	X2=3074353;	Y1=3592272;	Y2=3516891;	R=133886;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3773724;	X2=3568452;	Y1=3751243;	Y2=3274758;	R=681757;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3987212;	X2=3951198;	Y1=2416515;	Y2=2418718;	R=38217;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=61559;	X2=595451;	Y1=3806326;	Y2=3788543;	R=551675;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2693503;	X2=2269881;	Y1=2291389;	Y2=2661753;	R=793986;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3953437;	X2=3951198;	Y1=2669220;	Y2=2418718;	R=252741;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=763035;	X2=595451;	Y1=3997568;	Y2=3788543;	R=376609;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3999814;	X2=3951198;	Y1=2370103;	Y2=2418718;	R=97231;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=1290383;	X2=1749091;	Y1=1696257;	Y2=2000000;	R=762451;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3505508;	X2=3568452;	Y1=2805537;	Y2=3274758;	R=532165;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3276207;	X2=3568452;	Y1=3323122;	Y2=3274758;	R=340609;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2244609;	X2=3074353;	Y1=3517499;	Y2=3516891;	R=830352;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=1370860;	X2=595451;	Y1=3436382;	Y2=3788543;	R=1127570;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3831063;	X2=3568452;	Y1=3042662;	Y2=3274758;	R=494707;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=551202;	X2=595451;	Y1=3971545;	Y2=3788543;	R=227251;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=336629;	X2=595451;	Y1=2519780;	Y2=3788543;	R=1527585;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=2033602;	X2=2269881;	Y1=2882628;	Y2=2661753;	R=457154;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3939808;	X2=3951198;	Y1=2478271;	Y2=2418718;	R=70943;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			X1=3039958;	X2=3074353;	Y1=3574483;	Y2=3516891;	R=91987;
			coord = new Coord(X1,X2,Y1,Y2,R);
			sensorAndBeacon.add(coord);
			//PART 1
			
			for(Coord c: sensorAndBeacon){
				raggio = c.getR();
				xMin = c.getX1() - c.getR();
				xMax = c.getX1() + c.getR();
				
				for(int y = 4000000; y > 0; y--) {
					listaDuemilioni = new TreeMap<>();
					for (int i = (int) xMin; i <= xMax; i++){
						raggioCalcolato = Math.abs(c.getX1()-i)+Math.abs(c.getY1()-y);

						if (raggioCalcolato == raggio){
							System.out.println("Punto: " + i);
							if (xUno == 0) xUno = i;
							else if (xDue == 0 ) xDue = i;
							
						}
					}
					for (int i = (int) xUno; i<= xDue; i++){
						listaDuemilioni.put(i, "#") ;	
					}
		
					for(int x = 0; x < 4000000; x++) {
						if (listaQuattrmilioni.get(new Assi(x,y))==null)
							listaQuattrmilioni.put(new Assi( x, y), ".");
						else if (listaQuattrmilioni.get(new Assi(x,y)).equals("#"))
							continue;
						else
						{
							if (listaDuemilioni.get(x) != null){
								if (listaDuemilioni.get(x).equals("#"))
									listaQuattrmilioni.put(new Assi( x, y), "#");	
							}	
						}
						
						
						
							
					}
				}

			}
			
			
			for (Assi a: listaQuattrmilioni.keySet())
			{
				System.out.println("Valore: " +  a);
				if (listaQuattrmilioni.get(a).equals(".")) System.out.println("X: " + a.X + " Y: " + a.Y + " valore: .");
				
			}
		
			System.out.println("TOTALE INCREASED: " + (totale-1));	
		}	
		
		catch(Exception e) {
		
			e.getStackTrace();
			System.out.println("error: "+ e.getMessage());
		}
		
			
	}

}
