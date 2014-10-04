package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        count=valor/100;
        valor=valor%100;
        
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        count=valor/50;
        valor=valor%50;
        
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        count=valor/20;
        valor=valor%20;
        
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        count=valor/10;
        valor=valor%10;
        
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        count=valor/5;
        valor=valor%5;
        
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;
        protected int posicao;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            if(posicao >= troco.papeisMoeda.length || troco.papeisMoeda[posicao]==null){
                return false;
            }
            else
                return true;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = troco.papeisMoeda[posicao];
            posicao++;
            return ret;
        }

        @Override
        public void remove() {
            troco.papeisMoeda[posicao]=null;
        }
    }
}
