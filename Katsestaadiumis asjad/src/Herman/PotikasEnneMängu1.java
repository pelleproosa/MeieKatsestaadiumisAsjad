
package Herman;
public class PotikasEnneMängu1 {

	public static void run() {
		//massiivis kaardid 6 tk käes
		//see massiiv sisaldab: 
		//0)numbriKõrgusLöömisel(2-14), 1)mast (1-4), 2)kaardiTrumpVäärtus(1-5), 3)mastiKõrgusAlustamisel(0-4), 4)võrdlusmoment(0-2), 5)kaardi kohalik ID (Kättevõtmisjrk(0-35)), 6)käidavus(0või1)
		// käidavust vist ei kasutanud, sest läksin selleks punktiks teisele massiivile üle
		
		int multiMassiivMinuKäsi[][];
		multiMassiivMinuKäsi = new int[36][6];
		int multiMassiivParimadKoos[][];
		multiMassiivParimadKoos = new int[6][4];
		int trump;
		int LR; //loendur: endaKäeKaardidLäbiKäia
		int LR2; //loendur: võrrelda enda käe kaarte omavahel, et leida selle mängija "parim" "alustaja kaart"  
		int IDLR; //loendur: võrrelda erinevate mängijate "parimaid" "alustaja kaarte"
		int asteNumber; //6,7,8,9,10,11,12,13,14 
		int mastNumber; //1,2,3,4
		int kaardiTrumpVäärtus; //1,2,3,4,5 //5 on trump //seda väärtust ma tegelikult ei kasuta siin üldse (EnneMängu osas); kuid ma tahan seda kasutada mänguosas, tapmisel
		int mastiKõrgusAlustamisel; //0,1,2,3,4
		int järjekorraNumberMeeles; //peab meeles huvipakkuvat kaarti massiivis
		int mänguAlustajaID; //mängu alustaja, ehk see, kellel on "pisem" kaart
		int playerActive; //mängija, kelle kord on tegutseda
		
		trump = 3; //esialgu on trump ärtu
		
		LR=0;
		do {//loogika täidab massiivi tühjad lüngad sisendinfo põhjal
			//sisend
			//SISEND SAADAKSE ANDMEBAASIST JA KIRJUTATAKSE MASSIIVI KAKS VÄÄRTUST: kõrgus ja mast
			//mastNumber=INININ; //initialize variable
			//asteNumber=INININ; //initialize variable
			//väljund
			//multiMassiivMinuKäsi[LR][0] = asteNumber; //initialize variable
			//multiMassiivMinuKäsi[LR][1] = mastNumber; //initialize variable
			if(mastNumber==trump) { //loogika täidab massiivi tühjad lüngad sisendinfo põhjal
				kaardiTrumpVäärtus=5;//seda väärtust ma tegelikult ei kasuta siin üldse (EnneMängu osas); kuid ma tahan seda kasutada mänguosas, tapmisel
				mastiKõrgusAlustamisel=0; //alustamisel otsitakse madalaimat kaarti; Järjekord on T6 T7 ... TA | C6 D6 H6 S6 C7...SA; trumbikaardid väljaarvatud paremp. osast
				} else { 
					kaardiTrumpVäärtus=mastNumber;//seda väärtust ma tegelikult ei kasuta siin üldse (EnneMängu osas); kuid ma tahan seda kasutada mänguosas, tapmisel
					mastiKõrgusAlustamisel=mastNumber;
					}
			multiMassiivMinuKäsi[LR][2] = kaardiTrumpVäärtus;
			multiMassiivMinuKäsi[LR][3] = mastiKõrgusAlustamisel;
			multiMassiivMinuKäsi[LR][5] = LR; // käeSisene kaardiID, sõltuvalt käe suurusest 0 kuni 35
			LR++;
		} while (LR <6);
		
		järjekorraNumberMeeles = 0;
		LR2=1;
		
		//  0		if(asteNumber == multiMassiivMinuKäsi[LR2-1][0])
		//	
		//	2		if(mastiKõrgusAlustamisel == multiMassiivMinuKäsi[LR2-1][3])
		//	3		if(asteNumber < multiMassiivMinuKäsi[LR2-1][0])
		//	4		if(mastiKõrgusAlustamisel == 0)
		//  5		
		//
		//kui 2, siis kui 3
		//muidu kui 4
		//muidu kui 0, siis kui 2  
		//muidu kui 0
		do {//loogika võrdleb minu käes olevaid kaarte, otsides "madalaimat"		
			mastiKõrgusAlustamisel = multiMassiivMinuKäsi[LR2][3];
			asteNumber = multiMassiivMinuKäsi[LR2][0];
			if(mastiKõrgusAlustamisel == multiMassiivMinuKäsi[LR2-1][3]) {
				if(asteNumber < multiMassiivMinuKäsi[LR2-1][0]) {
					järjekorraNumberMeeles = LR2;
				}
			}
			else if(mastiKõrgusAlustamisel == 0){
				järjekorraNumberMeeles = LR2;
			}
			else if(asteNumber == multiMassiivMinuKäsi[LR2-1][0]) {
				if(mastiKõrgusAlustamisel == multiMassiivMinuKäsi[LR2-1][3]) {
					järjekorraNumberMeeles = LR2;
				}
			}
			else if(asteNumber == multiMassiivMinuKäsi[LR2-1][0]) {
				järjekorraNumberMeeles = LR2;									
			}
			
			
		} while (LR2 <6);
		
		multiMassiivMinuKäsi[järjekorraNumberMeeles][4] = 1;
		//väljund
		//VÄLJUND SAADETAKSE ANDMEBAASI: kõrgeim kaart käest
		//OUTOUTOUT=järjekorraNumberMeeles // share info; 
		//tabelis ID1 järjekorraNumberMeeles  
		
		
		
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
		
		
		IDLR=1;
		järjekorraNumberMeeles = 0;
		//see massiiv sisaldab: 0)ID, 1)mastiKõrgusAlustamisel 2)asteNumber 3)alustaja(0või1)
		do {
			mastiKõrgusAlustamisel = multiMassiivParimadKoos[IDLR][3];
			asteNumber = multiMassiivParimadKoos[IDLR][0];
			
			if(mastiKõrgusAlustamisel < multiMassiivParimadKoos[IDLR-1][3]) {
				if(asteNumber > multiMassiivParimadKoos[IDLR-1][0]) {
					järjekorraNumberMeeles = IDLR;
				}
				
			}
		} while (IDLR<5);
		
		
		mänguAlustajaID=multiMassiivParimadKoos[järjekorraNumberMeeles][0];
									
		//playerActiveID = mänguAlustajaID // seda ootavad kõik teised mängijad; kui siia tekib väärtus, siis on selle teise kord, kelle väärtus tekitati
		//System.out.println("Mängija "+mänguAlustajaID+" alustab, sest tal on väikseim kaart: "+multiMassiivParimadKoos[järjekorraNumberMeeles][2]);
	
	
	}
}

