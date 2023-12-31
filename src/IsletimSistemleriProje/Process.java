package IsletimSistemleriProje;

public class Process {
	
	public int id;
	public int varisZamani;
	public int oncelik;
	public int calisacagiSure;
	public int MByte;
	public int printers;
	public int scanners;
	public int modems;
	public int cds;
	public int olumAdimi;
	public int calistigiSure;
	public String Color;
	public String Background;

	protected int fullPrinter = 2;
	protected int maxNormalMByte = 960;
	protected int maxCDs = 2;
	protected int maxModems = 1;
	protected int maxScanners = 1;
	protected int maxRealTimeMByte = 64;
	protected int maxCalistigiSure = 20;
	
	public boolean deleteProcess = false;
	
	public Process(int id, int varisZamani, int oncelik,int kalanZaman,int MByte,int printers,int scanners,int modems,int cds,String Color,String Background) {
		this.id =0000+id;
        this.varisZamani = varisZamani;
        this.oncelik = oncelik;
        this.calisacagiSure = kalanZaman;
        
        if(oncelik > 0 &&  MByte >= maxNormalMByte) {
        	System.out.println(" " + id + "    Hata - Proses (960 MB) tan daha fazla bellek talep ediyor – proses silindi");
        	deleteProcess=true;
        }else if(oncelik == 0 && MByte >= maxRealTimeMByte){
        	System.out.println(" " + id + "    HATA - Gerçek-zamanlı proses (64MB) tan daha fazla bellek talep ediyor - proses silindi");
        	deleteProcess=true;
        }else {
        	this.MByte = MByte;
        }
        
        if(!deleteProcess && (oncelik > 0 && (printers > fullPrinter || scanners > maxScanners || modems > maxModems || cds > maxCDs))) {
        	System.out.println(" " + id +"    HATA - Proses çok sayıda kaynak talep ediyor - proses silindi");
        	deleteProcess=true;
        }else if(!deleteProcess && (oncelik == 0 && (printers > fullPrinter || scanners > maxScanners || modems > maxModems || cds > maxCDs))) {
        	System.out.println(" " + id +"    HATA - Gerçek-zamanlı proses çok sayıda kaynak talep ediyor - proses silindi");
        	deleteProcess=true;
        }else {
        	this.printers = printers;
        	this.scanners = scanners;
        	this.modems = modems;
        	this.cds = cds;
        }
        this.olumAdimi = varisZamani*(-1); 
        this.calistigiSure=0;
        this.Color = Color;
        this.Background = Background;
	}
	
	public int getId(){
        return this.id;
    }

	public void yeniBasladi(int saniye, int kalanSure) {
        this.olumAdimi = 0;
    }

    public void bitti(int saniye, int kalanSure) {
        if (saniye < 10)
            if (id < 10)
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + "COMPLETED" +"\n");
            else
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " +  "  " + "COMPLETED" +"\n");

        if (saniye >= 10)
            if (id < 10)
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + "COMPLETED" +"\n");
            else
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + "COMPLETED" +"\n");

        this.olumAdimi = 0;
    }
    
    public void yurutuluyor(int saniye, int kalanSure) {
        this.olumAdimi = 0;
        if (saniye < 10)
            if (id < 10)
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + getStatus() +"\n");
            else
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + getStatus() +"\n");

        if (saniye >= 10)
            if (id < 10)
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + getStatus() +"\n");
            else
            	System.out.printf(" " + id + "    " + varisZamani + "       " + oncelik +
                		"          " + calisacagiSure + "      " + MByte + "      " + printers + "     " + scanners + "     " +
                		modems + "       " + cds + "    " + "  " + getStatus() +"\n");
    }
    
    public void zamanAsimi(int saniye, int kalanSure) {
    	System.out.printf(" " + id + "    HATA - Proses zaman aşımı (20 sn de tamamlanamadı) " +"\n");
    	deleteProcess = true;
    }
    
    public void askida(int saniye, int kalanSure) {
        this.olumAdimi = 0;   
    }
    
    public String getStatus() {
        if (olumAdimi == 1) {
            return "COMPLETED";
        } else {
            return "RUNNING";
        }
    }
}
