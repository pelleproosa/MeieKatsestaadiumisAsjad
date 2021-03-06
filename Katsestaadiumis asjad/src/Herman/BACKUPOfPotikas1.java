
/*
package Herman;
public class BACKUPOfPotikas1 {

	public static void start() {
		//massiivis kaardid 1-36 tk käes
		//massiivi väärtused iga kaardi kohta (teine alammassiiv) on: 
		//0)numbriKõrgusLöömisel(2-14), 1)mast (1-4), 2)kaardiTrumpVäärtus(1-5), 3)mastiKõrgusAlustamisel(0-4), 4)võrdlusmoment(0-2), 5)järjekorranumberKättevõtmisjrk(0-35), 6)käidavus(0või1või2)
		
		int multiMassiivMinuKäsi[][];
		multiMassiivMinuKäsi = new int[36][6];
		
		//TÕMBA KAART 
		//SIIN KOOD, mis paneb kaardi masti ja kõrguse massiivi
		int trump;
		trump = 3;
		int LR = 0; // ehk loendur: endaKäeKaardidLäbiKäia
		int LR2 = 1; // ehk loendur: võrrelda enda käe kaarte omavahel, et leida "alustaja kaart"  
		
		int kohalikSisendAsteNumber;
		int kohalikSisendMastNumber;
		
		int kohalikVäljundAsteNumber;		
		int kohalikVäljundMastNumber;

		
		
		int kohalikVäljundKaardiTrumpVäärtus;
		int kohalikVäljundMastiKõrgusAlustamisel;
		
		do {
			//sisend
			//SISEND SAADAKSE ANDMEBAASIST JA KIRJUTATAKSE MASSIIVI KAKS VÄÄRTUST: kõrgus ja mast
			//kohalikSisendMastNumber=INININ; //initialize variable
			//kohalikSisendAsteNumber=INININ; //initialize variable
			//väljund
			//multiMassiivMinuKäsi[LR][0] = kohalikSisendAsteNumber; //initialize variable
			//multiMassiivMinuKäsi[LR][1] = kohalikSisendMastNumber; //initialize variable
			if(kohalikSisendMastNumber==trump) {
				kohalikVäljundKaardiTrumpVäärtus=5;
				kohalikVäljundMastiKõrgusAlustamisel=0;
				} else { 
					kohalikVäljundKaardiTrumpVäärtus=kohalikSisendMastNumber;
					kohalikVäljundMastiKõrgusAlustamisel=kohalikSisendMastNumber;
					}
			multiMassiivMinuKäsi[LR][2] = kohalikVäljundKaardiTrumpVäärtus;
			multiMassiivMinuKäsi[LR][3] = kohalikVäljundMastiKõrgusAlustamisel;
			multiMassiivMinuKäsi[LR][5] = LR;
			LR++;
		} while (LR <36);
		
		int kohalikVäljundJärjekorraNumberMeeles;
		int kohalikSisendMastiKõrgusAlustamisel;
		kohalikVäljundJärjekorraNumberMeeles = 0;
		
		do {
			
			kohalikSisendMastiKõrgusAlustamisel = multiMassiivMinuKäsi[LR2][3];
			kohalikSisendAsteNumber = multiMassiivMinuKäsi[LR2][0];
			
			if(kohalikSisendMastiKõrgusAlustamisel < multiMassiivMinuKäsi[LR2-1][3]) {
				if(kohalikSisendAsteNumber > multiMassiivMinuKäsi[LR2-1][0]) {
					kohalikVäljundJärjekorraNumberMeeles = LR2;
				}				
			}
		} while (LR2 <36);
		
		multiMassiivMinuKäsi[kohalikVäljundJärjekorraNumberMeeles][4] = 1;
		//väljund
		//VÄLJUND SAADETAKSE ANDMEBAASI: kõrgeim kaart käest
		//OUTOUTOUT=kohalikVäljundJärjekorraNumberMeeles // share info; 
		//tabelis ID1 kohalikVäljundJärjekorraNumberMeeles  
		
		int playerActive;
		
		//sisend
		//SISEND SAADAKSE ANDMEBAASIST JA MUUTUJASSE kõigi mängijate madalaim trump (muu kaart)
		//NII MITU KAARTI KUI SAADAKSE, ON MÄNGIJATE ARV
		//MAX MÄNGIJATE ARV ESIALGU 6: kuni 6 mängija kaardid:
		//ID0AlustajaKaart[0][0] = INININ;
		//ID1AlustajaKaart[1][0] = INININ;
		//ID2AlustajaKaart[kaart][property] = INININ;
		//ID3AlustajaKaart[kaart][property] = INININ;
		//ID4AlustajaKaart[kaart][property] = INININ;
		//ID5AlustajaKaart[kaart][property] = INININ;
		//property on ID (massivi teine liige)
		//MängijateArv; loendan kuidag
		
		int IDLR;
		IDLR=1;
		int multiMassiivParimadKoos[][];
		multiMassiivParimadKoos = new int[6][4];
		kohalikVäljundJärjekorraNumberMeeles = 0;
		//see massiiv sisaldab: 0)ID, 1)mastiKõrgusAlustamisel 2)asteNumber 3)alustaja(0või1)
		do {
			kohalikSisendMastiKõrgusAlustamisel = multiMassiivParimadKoos[IDLR][3];
			kohalikSisendAsteNumber = multiMassiivParimadKoos[IDLR][0];
			
			if(kohalikSisendMastiKõrgusAlustamisel < multiMassiivParimadKoos[IDLR-1][3]) {
				if(kohalikSisendAsteNumber > multiMassiivParimadKoos[IDLR-1][0]) {
					kohalikVäljundJärjekorraNumberMeeles = IDLR;
				}
				
			}
		} while (IDLR<5);
	
		//multiMassiivParimadKoos[kohalikVäljundJärjekorraNumberMeeles][3] = 1; //pole vaja
		int mänguAlustajaID;
		mänguAlustajaID=multiMassiivParimadKoos[kohalikVäljundJärjekorraNumberMeeles][0];
									
		//playerActiveID = mänguAlustajaID // seda ootavad kõik teised mängijad; kui siia tekib väärtus, siis on selle teise kord, kelle väärtus tekitati
		//System.out.println("Mängija "+mänguAlustajaID+" alustab, sest tal on väikseim kaart: "+multiMassiivParimadKoos[kohalikVäljundJärjekorraNumberMeeles][2]);
	
	
	}
}
*/

