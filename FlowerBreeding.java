package indset;
import java.io.*;
import java.util.*;

public class FlowerBreeding {
	
	public static int genelen;
	public static double waterProb = .2;

	public static void main(String[] args) {
	/*	Tulips 
	 * white = 0, yellow = 1, red = 2, pink = 3, orange = 4, black = 5, purple = 6
		 {0,0,0,1,1,0,1,1,1,2,3,0,4,1,1,4,1,1,5,2,2,5,2,2,6,6,6}
		 {1,6,19} */
	/*Pansies
	 * white = 0, blue = 1, yellow = 2, red = 3, orange = 4, purple = 5
	 *  {0,0,1,2,2,1,2,2,2,3,3,1,4,4,4,2,2,2,3,3,5,3,3,5,4,4,5}
	 *  {1,6,18}
	 */
	/*Cosmos
	 * white = 0, yellow = 1, pink = 2, orange = 3, red = 4, black = 5
	 * {0,0,0,1,1,0,1,1,1,2,2,2,3,3,2,3,3,3,4,4,4,3,3,4,5,5,4}
	 * {1,7,18}
	 */
	/*Lilies
	 * white = 0, yellow = 1, red = 2, pink = 3, orange = 4, black = 5
	 * {0,0,0,1,0,0,1,1,0,2,3,0,4,1,1,4,1,1,5,2,3,5,2,3,4,4,0}
	 * {2,6,19}
	 */
	/*Hyacinth
	 * white = 0, blue = 1, yellow = 2, red = 3, pink = 4, orange = 5, purple = 6
	 * {0,0,1,2,2,0,2,2,2,3,4,0,5,2,2,5,2,2,3,3,3,1,3,3,6,6,6}
	 * {1,6,19}
	 */
	/*Windflower
	 * white = 0, blue = 1, orange = 2, red = 3, pink = 4, purple = 5
	 * {0,0,1,2,2,1,2,2,2,3,3,1,4,4,4,2,2,2,3,3,5,3,3,5,4,4,5}
	 * {1,6,18}
	 */
	/*Mum
	 * white = 0, purple = 1, yellow = 2, pink = 3, red = 4, green = 5
	 * {0,0,1,2,2,0,2,2,2,3,3,3,2,4,3,1,1,1,4,4,4,1,1,4,5,5,4}
	 * {1,6,18}
	 */
	/*Rose
	 * white = 0, purple = 1, yellow = 2, red = 3, pink = 4, orange = 5, black = 6, blue = 7
	 * {0,0,0,0,0,0,1,1,1,2,2,2,0,0,0,1,1,1,2,2,2,2,2,2,0,0,0,3,4,0,3,4,0,3,4,1,5,2,2,3,4,0,3,4,1,5,2,2,5,2,2,3,4,0,6,3,4,6,3,4,6,3,4,5,5,2,3,3,0,6,3,1,5,5,2,5,5,2,7,3,0}
	 * {3,18,55}
	 */
		double[] genexpreps; //expected reproductions to get to genotype
		int[] gentophen; //genotype to phenotype 
		int[] start; //starting genotypes
/*		Scanner kb = new Scanner(System.in);
		System.out.print("Flower Species: ");
		String species = kb.next();
		System.out.print("Hybrid Starters? ");
		String hst = kb.next();
		kb.close(); */
		String species = "Lily";
		String hst = "N";
		switch(species) {
		case "Rose":
			genelen = 4;
			gentophen = new int[]{0,0,0,0,0,0,1,1,1,2,2,2,0,0,0,1,1,1,2,2,2,2,2,2,0,0,0,3,4,0,3,4,0,3,4,1,5,2,2,3,4,0,3,4,1,5,2,2,5,2,2,3,4,0,6,3,4,6,3,4,6,3,4,5,5,2,3,3,0,6,3,1,5,5,2,5,5,2,7,3,0};
			if(hst.equals("Y")) {
				start = new int[] {3,18,55,62,76};
			}
			else {
				start = new int[] {3,18,55};
			}
			break;
		case "Tulip":
			genelen = 3;
			gentophen = new int[] {0,0,0,1,1,0,1,1,1,2,3,0,4,1,1,4,1,1,5,2,2,5,2,2,6,6,6};
			if(hst.equals("Y")) {
				start = new int[] {1,6,10,15,19,21};
			}
			else {
				start = new int[] {1,6,19};
			}
			break;
		case "Pansy":
			genelen = 3;
			gentophen = new int[] {0,0,1,2,2,1,2,2,2,3,3,1,4,4,4,2,2,2,3,3,5,3,3,5,4,4,5};
			if(hst.equals("Y")) {
				start = new int[] {1,6,11,18,25};
			}
			else {
				start = new int[] {1,6,18};
			}
			break;
		case "Cosmo":
			genelen = 3;
			gentophen = new int[] {0,0,0,1,1,0,1,1,1,2,2,2,3,3,2,3,3,3,4,4,4,3,3,4,5,5,4};
			if(hst.equals("Y")) {
				start = new int[] {1,7,14,18,22};
			}
			else {
				start = new int[] {1,7,18};
			}
			break;
		case "Lily":
			genelen = 3;
			gentophen = new int[] {0,0,0,1,0,0,1,1,0,2,3,0,4,1,1,4,1,1,5,2,3,5,2,3,4,4,0};
			if(hst.equals("Y")) {
				start = new int[] {2,6,19,21,23,25};
			}
			else {
				start = new int[] {2,6,19,4,10,11,12,13,18,20,9,22,0,1,3,23,26,16,14};
			}
			break;
		case "Hyacinth":
			genelen = 3;
			gentophen = new int[] {0,0,1,2,2,0,2,2,2,3,4,0,5,2,2,5,2,2,3,3,3,1,3,3,6,6,6};
			if(hst.equals("Y")) {
				start = new int[] {1,6,10,15,19,21};
			}
			else {
				start = new int[] {1,6,19};
			}
			break;
		case "Windflower":
			genelen = 3;
			gentophen = new int[] {0,0,1,2,2,1,2,2,2,3,3,1,4,4,4,2,2,2,3,3,5,3,3,5,4,4,5};
			if(hst.equals("Y")) {
				start = new int[] {1,6,11,18,25};
			}
			else {
				start = new int[] {1,6,18};
			}
			break;
		case "Mum":
			genelen = 3;
			gentophen = new int[] {0,0,1,2,2,0,2,2,2,3,3,3,2,4,3,1,1,1,4,4,4,1,1,4,5,5,4};
			if(hst.equals("Y")) {
				start = new int[] {1,6,14,18,22};
			}
			else {
				start = new int[] {1,6,18};
			}
			break;
		default:
			genelen = 0;
			gentophen = new int[1];
			start = new int[1];
			break;
		}
		int numgens = gentophen.length;
		genexpreps = new double[numgens];
		for(int i = 0; i < numgens; i++) {
			genexpreps[i] = Double.MAX_VALUE;
		}
		for(int i = 0; i < start.length; i++) {
			genexpreps[start[i]] = 0;
		}
		
		double[][][] probdist = new double[numgens][numgens][numgens]; //probability distribution for child given parents
		for(int i = 0; i < numgens; i++) {
			for(int j = 0; j < numgens; j++) {
				for(int k = 0; k < numgens; k++) {
					probdist[i][j][k] = probInher(i,j,k);
				}
			}
		}
		boolean[][][] gensafe = new boolean[numgens][numgens][numgens];
		for(int par1 = 0; par1<numgens; par1++) {
			for(int par2 = 0; par2 < numgens; par2++) {					
				for(int a = 0; a < numgens; a++) {
					gensafe[par1][par2][a] = true;
					for(int b = 0; b < numgens; b++) {
						if((!(a==b)) && probdist[par1][par2][a] > 0 && probdist[par1][par2][b] > 0 && gentophen[a]==gentophen[b]) {
							gensafe[par1][par2][a] = false;
						}
					}
				}
			}
		}		
		
		double[][][] repgentest = new double[numgens][numgens][numgens]; //expected reproductions of a with c to distinguish a from b
		for(int a = 0; a < numgens; a++) {
			for(int b = 0; b < numgens; b++) {
				if(gentophen[a] == gentophen[b]) {
					for(int c = 0; c < numgens; c++) {
						boolean[] cola = new boolean[8];
						boolean[] colb = new boolean[8];
						for(int d = 0; d < numgens; d++) {
							if(probdist[a][c][d] > 0) {
								cola[gentophen[d]] = true;
							}
							if(probdist[b][c][d] > 0) {
								colb[gentophen[d]] = true;
							}
						}
						boolean[] vis = new boolean[8];
						for(int i = 0; i < 8; i++) {
							vis[i] = cola[i];
							if(colb[i]) {
								vis[i] = false;
							}
						}
						double testprob = 0;
						for(int i = 0; i < numgens; i++) {
							if(vis[gentophen[i]]) {
								testprob+=probdist[a][c][i];
							}
						}
						repgentest[a][b][c] = (double)1/testprob;
					}
				}
				else {
					for(int c = 0; c < numgens; c++) {
						repgentest[a][b][c] = 0;
					}
				}
			}
		}
		
		double[][] selfreptest = new double[numgens][numgens]; //testing reproduction against clone
		for(int a = 0; a < numgens; a++) {
			for(int b = 0; b < numgens; b++) {
				if(gentophen[a] == gentophen[b]) {
					boolean[] cola = new boolean[8];
					boolean[] colb = new boolean[8];
					for(int d = 0; d < numgens; d++) {
						if(probdist[a][a][d] > 0) {
							cola[gentophen[d]] = true;
						}
						if(probdist[b][b][d] > 0) {
							colb[gentophen[d]] = true;
						}
					}
					boolean[] vis = new boolean[8];
					for(int i = 0; i < 8; i++) {
						vis[i] = cola[i];
						if(colb[i]) {
							vis[i] = false;
						}
					}
					double testprob = 0;
					for(int i = 0; i < numgens; i++) {
						if(vis[gentophen[i]]) {
							testprob+=probdist[a][a][i];
						}
					}
					selfreptest[a][b] = (double)1/testprob;
				}
				else {
					for(int c = 0; c < numgens; c++) {
						selfreptest[a][b] = 0;
					}
				}
			}
		}
		
		int[][] optparents = new int[numgens][2];
		for(int i = 0; i < numgens; i++) {
			optparents[i][0] = -1;
			optparents[i][1] = -1;
		}
		boolean[] needtest = new boolean[numgens];
		boolean[][] testpartner = new boolean[numgens][numgens];
		boolean[] needclone = new boolean[numgens];
		
		for(int iter = 0; iter < 50; iter++) {
			/*for(int a = 0; a < numgens; a++) {
				needtest[a] = false;
				needclone[a] = false;
				for(int b = 0; b < numgens; b++) {
					testpartner[a][b] = false;
				}
			}*/
			for(int par1 = 0; par1 < numgens; par1++) {
				for(int par2 = 0; par2 < numgens; par2++) {
					boolean[] poschi = new boolean[numgens];
					for(int i = 0; i < numgens; i++) {
						if(probdist[par1][par2][i] > 0) {
							poschi[i] = true;
						}
					}
					for(int child = 0; child < numgens; child++) {
						if(poschi[child]) {
							if(gensafe[par1][par2][child]) {
								if(par1==par2) {
									if(genexpreps[par1] + Math.min(genexpreps[par2], 1) + 1/probdist[par1][par2][child] < genexpreps[child]) {
										genexpreps[child] = genexpreps[par1] + Math.min(genexpreps[par2], 1) + 1/probdist[par1][par2][child];
										optparents[child][0] = par1;
										optparents[child][1] = par2;
										needtest[child] = false;
									}
								}
								else {
									if(genexpreps[par1] + genexpreps[par2] + 1/probdist[par1][par2][child] < genexpreps[child]) {
										genexpreps[child] = genexpreps[par1] + genexpreps[par2] + 1/probdist[par1][par2][child];
										optparents[child][0] = par1;
										optparents[child][1] = par2;
										needtest[child] = false;
									}
								}
							}
							double testtime = 0;
							for(int ochi = 0; ochi < numgens; ochi++) {
								if(poschi[ochi] && !(ochi == child) && gentophen[ochi] == gentophen[child]) {
									double singletest = Double.MAX_VALUE;
									for(int testpar = 0; testpar < numgens; testpar++) {
										if(repgentest[child][ochi][testpar] + genexpreps[testpar] < singletest) {
											singletest = repgentest[child][ochi][testpar] + genexpreps[testpar];
										}
									}
									if(selfreptest[child][ochi] < singletest) {
										singletest = selfreptest[child][ochi];
									}
									for(int testpar = 0; testpar < numgens; testpar++) {
										if(singletest == repgentest[child][ochi][testpar] + genexpreps[testpar]) {
											testpartner[child][testpar] = true;
										}
									}
									if(selfreptest[child][ochi]==singletest) {
										needclone[child] = true;
									}
									testtime+=singletest;
								}
							}
							if(par1==par2) {
								if(genexpreps[par1] + Math.min(genexpreps[par2],1) + 1/probdist[par1][par2][child] + testtime < genexpreps[child]) {
									genexpreps[child] = genexpreps[par1] + Math.min(genexpreps[par2],1) + 1/probdist[par1][par2][child] + testtime;
									optparents[child][0] = par1;
									optparents[child][1] = par2;
									needtest[child] = true;
								}
							}
							else {
								if(genexpreps[par1] + genexpreps[par2] + 1/probdist[par1][par2][child] + testtime < genexpreps[child]) {
									genexpreps[child] = genexpreps[par1] + genexpreps[par2] + 1/probdist[par1][par2][child] + testtime;
									optparents[child][0] = par1;
									optparents[child][1] = par2;
									needtest[child] = true;
								}
							}
						}	
					}
				}
			}
		}
		
		int[] numused = new int[numgens];
		for(int i = 0; i < numgens; i++) {
			System.out.print(i + ": " + genexpreps[i] + " by breeding " + optparents[i][0] + ", " + optparents[i][1]);
			if(optparents[i][0]>-1) {
				numused[optparents[i][0]]+=1;
			}
			if(optparents[i][1]>-1) {
				numused[optparents[i][1]]+=1;
			}
			if(needtest[i]) {
				System.out.print(" and testing against ");
				for(int j = 0; j < numgens; j++) {
					if(testpartner[i][j]) {
						System.out.print(j + ", ");
						//numused[j]+=1;
					}
				}
				if(needclone[i]) {
					System.out.print("and cloning");
				}
			}
			System.out.println();
		}
		System.out.println();
		int count = 0;
		for(int i = 0; i < numgens; i++) {
			if(genexpreps[i] > 100000) {
				System.out.print(i + " (" + gentophen[i] + "), ");
				count++;
			}
		}
		System.out.println();
		System.out.println(count);
		for(int i = 0; i < numgens; i++) {
			System.out.println(i + " appears " + numused[i] + " times");
		}
		System.out.println();
		int[] depth = new int[numgens];
		for(int i = 0; i < numgens; i++) {
			depth[i] = 100;
		}
		for(int i = 0; i < start.length; i++) {
			depth[start[i]] = 0;
		}
		for(int iter = 0; iter < 50; iter++) {
			for(int i = 0; i < numgens; i++) {
				if(optparents[i][0] > -1 && optparents[i][1] > -1) {
					depth[i] = Math.max(depth[optparents[i][0]],depth[optparents[i][1]]);
					if(needtest[i]) {
						for(int j = 0; j < numgens; j++) {
						if(testpartner[i][j] && depth[j] > depth[i]) {
								depth[i] = depth[j];
							}
						}
					}
					depth[i]+=1;
				}
			}
		}
/*		for(int i = 0; i < numgens; i++) {
			System.out.println(i + ": " + depth[i]);
		}*/
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < numgens; j++) {
				if(depth[j] == i) {
					System.out.print(j + " (" + numused[j]+ ") ");
				}
			}
			System.out.println();
		}
		System.out.println(depth[6]);
		
		
		
		

	
	}
	
	
	public static double probInher(int a, int b, int c) {
		int quot = (int) Math.pow(3,genelen-1);
		double prob = 1;
		for(int i = 0; i < genelen; i++) {
			int adig = a/quot;
			a-=adig*quot;
			int bdig = b/quot;
			b-=bdig*quot;
			int cdig = c/quot;
			c-=cdig*quot;
			quot/=3;
			prob*=probInherSingle(adig,bdig,cdig);
		}
		return prob;
	}

	public static double probInherSingle(int a, int b, int c) {
		if(a > b) {
			int d = a;
			a = b;
			b = d;
		}
		switch(a) {
			case 0:
			switch(b) {
				case 0:
				switch(c) {
					case 0: return 1;
					case 1: return 0;
					case 2: return 0;
				}
				
				case 1:
				switch(c) {
					case 0: return .5;
					case 1: return .5;
					case 2: return 0;
				}
				
				case 2:
				switch(c) {
					case 0: return 0;
					case 1: return 1;
					case 2: return 0;
				}
			}
			
			case 1:
			switch(b) {
				case 1:
				switch(c) {
					case 0: return .25;
					case 1: return .5;
					case 2: return .25;
				}
				case 2:
				switch(c) {
					case 0: return 0;
					case 1: return .5;
					case 2: return .5;
				}
			}
			
			case 2:
			switch(c) {
				case 0: return 0;
				case 1: return 0;
				case 2: return 1;
			}
		}
		return 0;
	}

}