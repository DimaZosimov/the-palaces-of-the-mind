package fourth.aggregation.third;

/**
 * 
 * @author Dima Zosimov
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Country belarus = createData();
		System.out.println("Столица " + belarus.getCapital());
		System.out.println("Площадь " + belarus.getSquare() + " км2");
		System.out.println("Области\n" + belarus.getList());
		System.out.println("Областные центры:");
		for(Region r : belarus.getList()) {
			System.out.println(r.getCapital());
		}
	}
	
	static Country createData() {
		Region brestReg = new Region("Брестская область");
		Region grodnoReg = new Region("Гродненская область");
		Region vitebskReg = new Region("Витебская область");
		Region gomelReg = new Region("Гомельская область");
		Region mogilevReg = new Region("Могилевская область");
		Region minskReg = new Region("Минская облатсь");
		District brestDis = new District("Брестский район");
		District pinskDis = new District("Пинский район");
		District baranovichiDis = new District("Барановический район");
		City brest = new City("Брест", brestReg, brestDis);
		City pinsk = new City("Пинск", brestReg, pinskDis);
		City baranovichi = new City("Барановичи", brestReg, baranovichiDis);
		brestDis.setCapital(brest);
		pinskDis.setCapital(pinsk);
		baranovichiDis.setCapital(baranovichi);
		brestReg.setCapital(brest);
				
		District grodnoDis = new District("Гродненский район");
		District lidaDis = new District("Лидский район");
		District ostrovecDis = new District("Островецкий район");
		City grodno = new City("Гродно", grodnoReg, grodnoDis);
		City lida = new City("Лида", grodnoReg, lidaDis);
		City ostrovec = new City("Островец", grodnoReg, ostrovecDis);
		grodnoDis.setCapital(grodno);
		grodnoReg.setCapital(grodno);
		lidaDis.setCapital(lida);
		ostrovecDis.setCapital(ostrovec);
		
		District vitebskDis = new District("Витебский район");
		District orshaDis = new District("Оршанский район");
		District polockDis = new District("Полоцкий район");
		City vitebsk = new City("Витебск", vitebskReg, vitebskDis);
		City orsha = new City("Орша", vitebskReg, orshaDis);
		City polock = new City("Полоцк", vitebskReg, polockDis);
		vitebskReg.setCapital(vitebsk);
		vitebskDis.setCapital(vitebsk);
		orshaDis.setCapital(orsha);
		polockDis.setCapital(polock);
		
		
		District gomelDis = new District("Гомельский район");
		District zhitkovichiDis = new District("Житковичский район");
		District rechicaDis = new District("Речицкий район");
		City gomel = new City("Гомель", gomelReg, gomelDis);
		City turov = new City("Туров", gomelReg, zhitkovichiDis);
		City rechica = new City("Речица", gomelReg, rechicaDis);
		gomelReg.setCapital(gomel);
		gomelDis.setCapital(gomel);
		rechicaDis.setCapital(rechica);
		
		District mogilevDis = new District("Могилевский раойн");
		District bobruyskDis = new District("Бобруйский район");
		District mstislavlDis = new District("Мстиславский район");
		City mogilev = new City("Могилев", mogilevReg, mogilevDis);
		City bobruisk = new City("Бобруйск", mogilevReg, bobruyskDis);
		City mstislavl = new City("Мстиславль", mogilevReg, mstislavlDis);
		mogilevReg.setCapital(mogilev);
		mogilevDis.setCapital(mogilev);
		bobruyskDis.setCapital(bobruisk);
		mstislavlDis.setCapital(mstislavl);
		
		District minskDis = new District("Минский район");
		District borisovDis = new District("Борисовский район");
		District slutskDis = new District("Слуцкий раойн");
		City minsk = new City("Минск", minskReg, minskDis);
		City borisov = new City("Борисов", minskReg, borisovDis);
		City slutsk = new City("Слуцк", minskReg, slutskDis);
		minskReg.setCapital(minsk);
		minskDis.setCapital(minsk);
		borisovDis.setCapital(borisov);
		slutskDis.setCapital(slutsk);
		
		Country belarus = new Country("Беларусь");
		belarus.setCapital(minsk);
		belarus.add(vitebskReg);
		belarus.add(brestReg);
		belarus.add(minskReg);
		belarus.add(mogilevReg);
		belarus.add(gomelReg);
		belarus.add(grodnoReg);
		belarus.setSquare(207595);
		return belarus;
		
	}

}
