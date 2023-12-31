package IsletimSistemleriProje;

public class main {

	public static void main(String[] args) {
		// Tum prosesleri okuyabilmek icin liste
		DoublyLinkedList tumListe = new DoublyLinkedList();
		
		// Dosya okumak icin bir Dosya object olusturalim
        Dosya dosya = new Dosya();
        
        // Onceligi gore list olusturuyoruz
        DoublyLinkedList p0 = new DoublyLinkedList();
        DoublyLinkedList p1 = new DoublyLinkedList();
        DoublyLinkedList p2 = new DoublyLinkedList();
        DoublyLinkedList p3 = new DoublyLinkedList();
        
        // Dogum list icin
        Node node;
        Node nodeTutucu;
        
        // Cikti icin baslik
        System.out.println("Pid   varış   öncelik    cpu    MBytes   prn   scn   modem   cd     status");
        
        // oncelik icin bir degisken
        int oncelik;
        
        // Dosya okumak icin dosyanin location yazilmali veya args[0] olarak verilmeli
        tumListe = dosya.Oku("C:\\Users\\Enes\\Desktop\\donem 4\\PDP\\Eclipse\\OSProject\\girisTest.txt");
        
        // onceliklerine göre listelere atılıyor...
        for (int i = 0; i < tumListe.size; i++) {
            oncelik = tumListe.head.process.oncelik;
            if (oncelik == 0) {
                node = new Node(tumListe.head.process);
                p0.addLast(node);
            }
            if (oncelik == 1) {
                node = new Node(tumListe.head.process);
                p1.addLast(node);
            }
            if (oncelik == 2) {
                node = new Node(tumListe.head.process);
                p2.addLast(node);
            }
            if (oncelik == 3) {
                node = new Node(tumListe.head.process);
                p3.addLast(node);
            }
            tumListe.sonraki();
        }
        
        // Gereken degiskenlerin tanimlanmasi
        int yenimiBasladi = 0;
        int calistigiSure = 0;
        int calisacagiSure = 0;
        int gercekZaman = 0;
        int gercekZamanIcerideArtmadi = 0;
        
        // infinite loop, her proses bitene kadar calisacak
        while (true) {
            gercekZamanIcerideArtmadi = 0;
            
            // Gercek zaman proses gelmemise
            if (p0.head != null) {
            	// Gelmise FCFS ile calistirabilmek icin kontrol
                if (p0.head.process.varisZamani <= gercekZaman) {
                	//Tanimlamalar
                    calisacagiSure = p0.head.process.calisacagiSure;
                    calistigiSure = p0.head.process.calistigiSure;
                    yenimiBasladi = calisacagiSure - calistigiSure;
                    
                    if (yenimiBasladi == calisacagiSure) {
                        p0.head.process.yeniBasladi(gercekZaman, yenimiBasladi);
                        p0.head.process.calistigiSure++;
                        gercekZaman++;
                    } else if (yenimiBasladi < calisacagiSure && yenimiBasladi > 0) {
                        p0.head.process.yurutuluyor(gercekZaman, yenimiBasladi);
                        p0.head.process.calistigiSure++;
                        gercekZaman++;
                    }
                    calisacagiSure = p0.head.process.calisacagiSure;
                    calistigiSure = p0.head.process.calistigiSure;
                    yenimiBasladi = calisacagiSure - calistigiSure;
                    if (yenimiBasladi == 0) {
                        p0.head.process.bitti(gercekZaman, yenimiBasladi);
                        p0.sonraki();
                    }
                  
                    p0.olumDegeriArttir(p0, p1, p2, p3, gercekZaman);
                    continue;
                } else
                    gercekZamanIcerideArtmadi++;
            }

            if (p1.head != null) {
                if (p1.head.process.varisZamani <= gercekZaman) {
                    calisacagiSure = p1.head.process.calisacagiSure;
                    calistigiSure = p1.head.process.calistigiSure;
                    yenimiBasladi = calisacagiSure - calistigiSure;
                    if (yenimiBasladi == calisacagiSure) {
                        p1.head.process.yeniBasladi(gercekZaman, yenimiBasladi);
                        p1.head.process.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p1.head.process.calisacagiSure;
                        calistigiSure = p1.head.process.calistigiSure;
                        yenimiBasladi = calisacagiSure - calistigiSure;
                        if (yenimiBasladi == 0) {
                            p1.head.process.bitti(gercekZaman, yenimiBasladi);
                            p1.sonraki();
                        } else {
                            p1.head.process.oncelik = 2;
                            p1.head.process.askida(gercekZaman, yenimiBasladi);
                            nodeTutucu = new Node(p1.head.process);
                            p2.arayaEkle(nodeTutucu, gercekZaman);
                            p1.sonraki();
                        }
                    }
                    p0.olumDegeriArttir(p0, p1, p2, p3, gercekZaman);
                    continue;
                } else
                    gercekZamanIcerideArtmadi++;
            }
            if (p2.head != null) {
                if (p2.head.process.varisZamani <= gercekZaman) {
             
                    calisacagiSure = p2.head.process.calisacagiSure;
                    calistigiSure = p2.head.process.calistigiSure;
                    yenimiBasladi = calisacagiSure - calistigiSure;
                    if (yenimiBasladi == calisacagiSure) {
                        p2.head.process.yeniBasladi(gercekZaman, yenimiBasladi);
                        p2.head.process.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p2.head.process.calisacagiSure;
                        calistigiSure = p2.head.process.calistigiSure;
                        yenimiBasladi = calisacagiSure - calistigiSure;
                        if (yenimiBasladi == 0) {
                            p2.head.process.bitti(gercekZaman, yenimiBasladi);
                            p2.sonraki();
                        } else {
                            p2.head.process.oncelik = 3;
                            p2.head.process.askida(gercekZaman, yenimiBasladi);
                            nodeTutucu = new Node(p2.head.process);
                            p3.arayaEkle(nodeTutucu, gercekZaman);
                            p2.sonraki();
                        }
                    } else if ((calisacagiSure > calistigiSure)) {
                        p2.head.process.yurutuluyor(gercekZaman, yenimiBasladi);
                        p2.head.process.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p2.head.process.calisacagiSure;
                        calistigiSure = p2.head.process.calistigiSure;
                        yenimiBasladi = calisacagiSure - calistigiSure;
                        if (yenimiBasladi == 0) {
                            p2.head.process.bitti(gercekZaman, yenimiBasladi);
                            p2.sonraki();
                        } else {
                            p2.head.process.oncelik = 3;
                            p2.head.process.askida(gercekZaman, yenimiBasladi);
                            nodeTutucu = new Node(p2.head.process);
                            p3.arayaEkle(nodeTutucu, gercekZaman);
                            p2.sonraki();
                        }
                    }
                    p0.olumDegeriArttir(p0, p1, p2, p3, gercekZaman);
                    continue;
                } else
                    gercekZamanIcerideArtmadi++;

            }
            if (p3.head != null) {
                if (p3.head.process.varisZamani <= gercekZaman) {
                	 
                    calisacagiSure = p3.head.process.calisacagiSure;
                    calistigiSure = p3.head.process.calistigiSure;
                    yenimiBasladi = calisacagiSure - calistigiSure;
                    if (yenimiBasladi == calisacagiSure) {
                        p3.head.process.yeniBasladi(gercekZaman, yenimiBasladi);
                        p3.head.process.calistigiSure++;
                        gercekZaman++;

                        calisacagiSure = p3.head.process.calisacagiSure;
                        calistigiSure = p3.head.process.calistigiSure;
                        yenimiBasladi = calisacagiSure - calistigiSure;
                        if (yenimiBasladi == 0) {
                            p3.head.process.bitti(gercekZaman, yenimiBasladi);
                            p3.deleteNode(p3.head);
                        } else {
                            p3.head.process.askida(gercekZaman, yenimiBasladi);
                            nodeTutucu = new Node(p3.head.process);
                            p3.arayaEkle(nodeTutucu, gercekZaman);
                            p3.deleteNode(p3.head);
                        }
                    } else if (yenimiBasladi < calisacagiSure && yenimiBasladi > 0) {
                        p3.head.process.yurutuluyor(gercekZaman, yenimiBasladi);
                        p3.head.process.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p3.head.process.calisacagiSure;
                        calistigiSure = p3.head.process.calistigiSure;
                        yenimiBasladi = calisacagiSure - calistigiSure;
                        if (yenimiBasladi == 0) {
                            p3.head.process.bitti(gercekZaman, yenimiBasladi);
                            p3.deleteNode(p3.head);
                        } else {

                            p3.head.process.askida(gercekZaman, yenimiBasladi);
                            nodeTutucu = new Node(p3.head.process);
                            p3.arayaEkle(nodeTutucu, gercekZaman);
                            p3.deleteNode(p3.head);

                        } //dugumu sona tasıyıp her şeyi bir sola kaydıracağız.
                    }
                    p0.olumDegeriArttir(p0, p1, p2, p3, gercekZaman);
                    continue;
                } else
                    gercekZamanIcerideArtmadi++;
            }
            if (gercekZamanIcerideArtmadi == 4) {
                p0.olumDegeriArttir(p0, p1, p2, p3, gercekZaman);
                gercekZaman++;
            }
            if (p0.IsEmpty() && p1.IsEmpty() && p2.IsEmpty() && p3.IsEmpty())
                break;
        }

	}

}
