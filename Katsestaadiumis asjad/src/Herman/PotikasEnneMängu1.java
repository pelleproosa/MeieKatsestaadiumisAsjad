
package Herman;
public class PotikasEnneM�ngu1 {

	public static void run() {
		//massiivis kaardid 6 tk k�es
		//see massiiv sisaldab: 
		//0)numbriK�rgusL��misel(2-14), 1)mast (1-4), 2)kaardiTrumpV��rtus(1-5), 3)mastiK�rgusAlustamisel(0-4), 4)v�rdlusmoment(0-2), 5)kaardi kohalik ID (K�ttev�tmisjrk(0-35)), 6)k�idavus(0v�i1)
		// k�idavust vist ei kasutanud, sest l�ksin selleks punktiks teisele massiivile �le
		
		int multiMassiivMinuK�si[][];
		multiMassiivMinuK�si = new int[36][6];
		int multiMassiivParimadKoos[][];
		multiMassiivParimadKoos = new int[6][4];
		int trump;
		int LR; //loendur: endaK�eKaardidL�biK�ia
		int LR2; //loendur: v�rrelda enda k�e kaarte omavahel, et leida selle m�ngija "parim" "alustaja kaart"  
		int IDLR; //loendur: v�rrelda erinevate m�ngijate "parimaid" "alustaja kaarte"
		int asteNumber; //6,7,8,9,10,11,12,13,14 
		int mastNumber; //1,2,3,4
		int kaardiTrumpV��rtus; //1,2,3,4,5 //5 on trump //seda v��rtust ma tegelikult ei kasuta siin �ldse (EnneM�ngu osas); kuid ma tahan seda kasutada m�nguosas, tapmisel
		int mastiK�rgusAlustamisel; //0,1,2,3,4
		int j�rjekorraNumberMeeles; //peab meeles huvipakkuvat kaarti massiivis
		int m�nguAlustajaID; //m�ngu alustaja, ehk see, kellel on "pisem" kaart
		int playerActive; //m�ngija, kelle kord on tegutseda
		
		trump = 3; //esialgu on trump �rtu
		
		LR=0;
		do {//loogika t�idab massiivi t�hjad l�ngad sisendinfo p�hjal
			//sisend
			//SISEND SAADAKSE ANDMEBAASIST JA KIRJUTATAKSE MASSIIVI KAKS V��RTUST: k�rgus ja mast
			//mastNumber=INININ; //initialize variable
			//asteNumber=INININ; //initialize variable
			//v�ljund
			//multiMassiivMinuK�si[LR][0] = asteNumber; //initialize variable
			//multiMassiivMinuK�si[LR][1] = mastNumber; //initialize variable
			if(mastNumber==trump) { //loogika t�idab massiivi t�hjad l�ngad sisendinfo p�hjal
				kaardiTrumpV��rtus=5;//seda v��rtust ma tegelikult ei kasuta siin �ldse (EnneM�ngu osas); kuid ma tahan seda kasutada m�nguosas, tapmisel
				mastiK�rgusAlustamisel=0; //alustamisel otsitakse madalaimat kaarti; J�rjekord on T6 T7 ... TA | C6 D6 H6 S6 C7...SA; trumbikaardid v�ljaarvatud paremp. osast
				} else { 
					kaardiTrumpV��rtus=mastNumber;//seda v��rtust ma tegelikult ei kasuta siin �ldse (EnneM�ngu osas); kuid ma tahan seda kasutada m�nguosas, tapmisel
					mastiK�rgusAlustamisel=mastNumber;
					}
			multiMassiivMinuK�si[LR][2] = kaardiTrumpV��rtus;
			multiMassiivMinuK�si[LR][3] = mastiK�rgusAlustamisel;
			multiMassiivMinuK�si[LR][5] = LR; // k�eSisene kaardiID, s�ltuvalt k�e suurusest 0 kuni 35
			LR++;
		} while (LR <6);
		
		j�rjekorraNumberMeeles = 0;
		LR2=1;
		
		//  0		if(asteNumber == multiMassiivMinuK�si[LR2-1][0])
		//	
		//	2		if(mastiK�rgusAlustamisel == multiMassiivMinuK�si[LR2-1][3])
		//	3		if(asteNumber < multiMassiivMinuK�si[LR2-1][0])
		//	4		if(mastiK�rgusAlustamisel == 0)
		//  5		
		//
		//kui 2, siis kui 3
		//muidu kui 4
		//muidu kui 0, siis kui 2  
		//muidu kui 0
		do {//loogika v�rdleb minu k�es olevaid kaarte, otsides "madalaimat"		
			mastiK�rgusAlustamisel = multiMassiivMinuK�si[LR2][3];
			asteNumber = multiMassiivMinuK�si[LR2][0];
			if(mastiK�rgusAlustamisel == multiMassiivMinuK�si[LR2-1][3]) {
				if(asteNumber < multiMassiivMinuK�si[LR2-1][0]) {
					j�rjekorraNumberMeeles = LR2;
				}
			}
			else if(mastiK�rgusAlustamisel == 0){
				j�rjekorraNumberMeeles = LR2;
			}
			else if(asteNumber == multiMassiivMinuK�si[LR2-1][0]) {
				if(mastiK�rgusAlustamisel == multiMassiivMinuK�si[LR2-1][3]) {
					j�rjekorraNumberMeeles = LR2;
				}
			}
			else if(asteNumber == multiMassiivMinuK�si[LR2-1][0]) {
				j�rjekorraNumberMeeles = LR2;									
			}
			
			
		} while (LR2 <6);
		
		multiMassiivMinuK�si[j�rjekorraNumberMeeles][4] = 1;
		//v�ljund
		//V�LJUND SAADETAKSE ANDMEBAASI: k�rgeim kaart k�est
		//OUTOUTOUT=j�rjekorraNumberMeeles // share info; 
		//tabelis ID1 j�rjekorraNumberMeeles  
		
		
		
		//sisend
		//SISEND SAADAKSE ANDMEBAASIST JA MUUTUJASSE k�igi m�ngijate madalaim trump (muu kaart)
		//NII MITU KAARTI KUI SAADAKSE, ON M�NGIJATE ARV
		//MAX M�NGIJATE ARV ESIALGU 6: kuni 6 m�ngija kaardid:
		//ID0AlustajaKaart[0][0] = INININ;
		//ID1AlustajaKaart[1][0] = INININ;
		//ID2AlustajaKaart[kaart][property] = INININ;
		//ID3AlustajaKaart[kaart][property] = INININ;
		//ID4AlustajaKaart[kaart][property] = INININ;
		//ID5AlustajaKaart[kaart][property] = INININ;
		//property on ID (massivi teine liige)
		
		
		IDLR=1;
		j�rjekorraNumberMeeles = 0;
		//see massiiv sisaldab: 0)ID, 1)mastiK�rgusAlustamisel 2)asteNumber 3)alustaja(0v�i1)
		do {
			mastiK�rgusAlustamisel = multiMassiivParimadKoos[IDLR][3];
			asteNumber = multiMassiivParimadKoos[IDLR][0];
			
			if(mastiK�rgusAlustamisel < multiMassiivParimadKoos[IDLR-1][3]) {
				if(asteNumber > multiMassiivParimadKoos[IDLR-1][0]) {
					j�rjekorraNumberMeeles = IDLR;
				}
				
			}
		} while (IDLR<5);
		
		
		m�nguAlustajaID=multiMassiivParimadKoos[j�rjekorraNumberMeeles][0];
									
		//playerActiveID = m�nguAlustajaID // seda ootavad k�ik teised m�ngijad; kui siia tekib v��rtus, siis on selle teise kord, kelle v��rtus tekitati
		//System.out.println("M�ngija "+m�nguAlustajaID+" alustab, sest tal on v�ikseim kaart: "+multiMassiivParimadKoos[j�rjekorraNumberMeeles][2]);
	
	
	}
}

