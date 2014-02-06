
package Herman;
public class Potikas1 {

	public static void start() {
		//massiivis kaardid 1-36 tk k‰es
		//massiivi v‰‰rtused iga kaardi kohta (teine alammassiiv) on: 
		//0)numbriKırgusLˆˆmisel(2-14), 1)mast (1-4), 2)kaardiTrumpV‰‰rtus(1-5), 3)mastiKırgusAlustamisel(0-4), 4)vırdlusmoment(0-2), 5)j‰rjekorranumberK‰ttevıtmisjrk(0-35), 6)k‰idavus(0vıi1vıi2)
		
		int multiMassiivKaardid[][];
		multiMassiivKaardid = new int[36][6];
		
		//T’MBA KAART 
		//SIIN KOOD, mis paneb kaardi masti ja kırguse massiivi
		int trump;
		trump = 3;
		int LR = 0; // ehk loendur: endaK‰eKaardidL‰biK‰ia
		int LR2 = 1; // ehk loendur: vırrelda enda k‰e kaarte omavahel, et leida "alustaja kaart"  
		
		int kohalikSisendAsteNumber;
		int kohalikSisendMastNumber;
		
		int kohalikV‰ljundAsteNumber;		
		int kohalikV‰ljundMastNumber;

		
		
		int kohalikV‰ljundKaardiTrumpV‰‰rtus;
		int kohalikV‰ljundMastiKırgusAlustamisel;
		//String kohalikV‰ljundAsteNimetus;
		//String kohalikV‰ljundMastNimetus;
		
		do {
			//sisend
			//SISEND SAADAKSE ANDMEBAASIST JA KIRJUTATAKSE MASSIIVI KAKS VƒƒRTUST: kırgus ja mast
			//kohalikSisendMastNumber=INININ; //initialize variable
			//kohalikSisendAsteNumber=INININ; //initialize variable
			//v‰ljund
			//multiMassiivKaardid[LR][0] = kohalikSisendAsteNumber; //initialize variable
			//multiMassiivKaardid[LR][1] = kohalikSisendMastNumber; //initialize variable
			if(kohalikSisendMastNumber==trump) {
				kohalikV‰ljundKaardiTrumpV‰‰rtus=5;
				kohalikV‰ljundMastiKırgusAlustamisel=0;
				} else { 
					kohalikV‰ljundKaardiTrumpV‰‰rtus=kohalikSisendMastNumber;
					kohalikV‰ljundMastiKırgusAlustamisel=kohalikSisendMastNumber;
					}
			multiMassiivKaardid[LR][2] = kohalikV‰ljundKaardiTrumpV‰‰rtus;
			multiMassiivKaardid[LR][3] = kohalikV‰ljundMastiKırgusAlustamisel;
			multiMassiivKaardid[LR][5] = LR;
			LR++;
		} while (LR <36);
		
		int kohalikV‰ljundJ‰rjekorraNumberMeeles;
		int kohalikSisendMastiKırgusAlustamisel;
		kohalikV‰ljundJ‰rjekorraNumberMeeles = 0;
		
		do {
			
			kohalikSisendMastiKırgusAlustamisel = multiMassiivKaardid[LR2][3];
			kohalikSisendAsteNumber = multiMassiivKaardid[LR2][0];
			
			if(kohalikSisendMastiKırgusAlustamisel < multiMassiivKaardid[LR2-1][3]) {
				if(kohalikSisendAsteNumber > multiMassiivKaardid[LR2-1][0]) {
					kohalikV‰ljundJ‰rjekorraNumberMeeles = LR2;
				}				
			}
		} while (LR2 <36);
		
		multiMassiivKaardid[kohalikV‰ljundJ‰rjekorraNumberMeeles][4] = 1;
		//v‰ljund
		//VƒLJUND SAADETAKSE ANDMEBAASI: kırgeim kaart k‰est
		//OUTOUTOUT=kohalikV‰ljundJ‰rjekorraNumberMeeles // share info; 
		//tabelis ID1 kohalikV‰ljundJ‰rjekorraNumberMeeles  
		
		int playerActive;
		
		//sisend
		//SISEND SAADAKSE ANDMEBAASIST JA MUUTUJASSE kıigi m‰ngijate madalaim trump (muu kaart)
		//NII MITU KAARTI KUI SAADAKSE, ON MƒNGIJATE ARV
		//MAX MƒNGIJATE ARV ESIALGU 6: kuni 6 m‰ngija kaardid:
		//ID0AlustajaKaart[0][0] = INININ;
		//ID1AlustajaKaart[1][0] = INININ;
		//ID2AlustajaKaart[kaart][property] = INININ;
		//ID3AlustajaKaart[kaart][property] = INININ;
		//ID4AlustajaKaart[kaart][property] = INININ;
		//ID5AlustajaKaart[kaart][property] = INININ;
		//property on ID (massivi teine liige)
		//M‰ngijateArv; loendan kuidag
		
		int IDLR;
		IDLR=1;
		int multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[][];
		multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus = new int[6][4];
		kohalikV‰ljundJ‰rjekorraNumberMeeles = 0;
		//see massiiv sisaldab: 0)ID, 1)mastiKırgusAlustamisel 2)asteNumber 3)alustaja(0vıi1)
		do {
			kohalikSisendMastiKırgusAlustamisel = multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[IDLR][3];
			kohalikSisendAsteNumber = multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[IDLR][0];
			
			if(kohalikSisendMastiKırgusAlustamisel < multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[IDLR-1][3]) {
				if(kohalikSisendAsteNumber > multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[IDLR-1][0]) {
					kohalikV‰ljundJ‰rjekorraNumberMeeles = IDLR;
				}
				
			}
			
		
		
						
		} while (IDLR<5);
	
		//multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[kohalikV‰ljundJ‰rjekorraNumberMeeles][3] = 1; //pole vaja
		int m‰nguAlustajaID;
		m‰nguAlustajaID=multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[kohalikV‰ljundJ‰rjekorraNumberMeeles][0];
									
		//playerActiveID = m‰nguAlustajaID // seda ootavad kıik teised m‰ngijad; kui siia tekib v‰‰rtus, siis on selle teise kord, kelle v‰‰rtus tekitati
		//System.out.println("M‰ngija "+m‰nguAlustajaID+" alustab, sest tal on v‰ikseim kaart: "+multiMassiivKaardidKıigiKaardidAlustamiseksVırdlus[kohalikV‰ljundJ‰rjekorraNumberMeeles][2]);
	
	
	}
}

