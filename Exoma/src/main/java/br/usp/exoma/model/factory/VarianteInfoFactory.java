package br.usp.exoma.model.factory;

import br.usp.exoma.model.Gene;
import br.usp.exoma.model.Variante;
import br.usp.exoma.model.VarianteInfo;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VarianteInfoFactory implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    public VarianteInfo makeVarianteInfo(String info, Variante variante){
        VarianteInfo vInfo = new VarianteInfo();
        vInfo.setGene(new Gene());
        vInfo.setAc(this.makeAc(info));
        vInfo.setAf(this.makeAf(info));
        vInfo.setDp(this.makeDp(info));
        vInfo.setFs(this.makeFs(info));
        vInfo.setExcessHet(this.makeExcessHet(info));        
        vInfo.setMleac(this.makeMleac(info));
        vInfo.setMleaf(this.makeMleaf(info));
        String ann = this.makeAnn(info);
        vInfo.setAnn(ann);
        //vInfo.setAnnotation(this.makeAnnotation(ann));
        
        String[] vAnn = ann.split("\\|");
        //vInfo.setAnnotation(String.valueOf(vAnn.length));
        if(vAnn.length>1)
            vInfo.setAnnotation(vAnn[1]);
        if(vAnn.length>2)
            vInfo.setImpacto(vAnn[2]);
        if(vAnn.length>3)
            // criar o gene aqui?
            vInfo.setGeneName(vAnn[3]);
            vInfo.getGene().setSymbol(vAnn[3]);
        if(vAnn.length>4)
            vInfo.setGeneId(vAnn[4]);
            vInfo.getGene().setEnsemblId(vAnn[4]);
        if(vAnn.length>5)
            vInfo.setFeatureId(vAnn[5]);
        if(vAnn.length>6)
            vInfo.setTranscriptBioType(vAnn[6]);
        if(vAnn.length>7)
            vInfo.setRank(vAnn[7]);
        if(vAnn.length>8)
            vInfo.setHgvsC(vAnn[8]);
        if(vAnn.length>9)
            vInfo.setHgvsP(vAnn[9]);
        if(vAnn.length>10)
            vInfo.setCdnaPosCdnaLen(vAnn[10]);
        
        if(vAnn.length>11)
            vInfo.setCdsPosCdsLen(vAnn[11]);
        
        if(vAnn.length>12)
            vInfo.setAaPosLen(vAnn[12]);
        if(vAnn.length>13)
            vInfo.setInfo(vAnn[13]);
        
       
        
        
        vInfo.setVariante(variante);
        return vInfo;
    }

    private Integer makeAc(String info) {
        String pattern = ".*AC=([0-9\\-]+).*";
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Integer.valueOf( retorno ));
        }
        return null;
    }
    
    private Double makeAf(String info){
        String pattern = ".*;AF=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    private Integer makeAn(String info){
        String pattern = ".*;AN=([0-9\\\\.]+);.*";     
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Integer.valueOf( retorno ));
        }
        return null;        
    }
    
    
    private Integer makeDp(String info) {
        String pattern = ".*;DP=([0-9\\-]+).*";
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Integer.valueOf( retorno ));
        }
        return null;
    }
    
    
    private Double makeExcessHet(String info){
        String pattern = ".*;ExcessHet=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    
        
    private Double makeFs(String info){
        String pattern = ".*;FS=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    
    private Integer makeMleac(String info) {
        String pattern = ".*;MLEAC=([0-9\\-]+).*";
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Integer.valueOf( retorno ));
        }
        return null;
    }
    
    
    private Double makeMleaf(String info){
        String pattern = ".*;MLEAF=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    private Double makeMq(String info){
        String pattern = ".*;MQ=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    
    private Double makeMqRankSum(String info){
        String pattern = ".*;MQRankSum=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    private Double makeQd(String info){
        String pattern = ".*;QD=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }
    
    private Double makeReadPosRankSum(String info){
        String pattern = ".*;ReadPosRankSum=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }    
    
    private Double makeSor(String info){
        String pattern = ".*;SOR=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }    

    private Double makeVqslod(String info){
        String pattern = ".*;VQSLOD=([0-9\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }        
    
    private Double makeCulprit(String info){
        String pattern = ".*;culprit=([a-zA-Z\\.]+);.*";        
        String retorno = this.parser(pattern, info);
        if(retorno != null){
            return (Double.valueOf( retorno ));
        }
        return null;
    }    
    
    private String makeAnn(String info){
        String pattern = ".*;ANN=([0-9a-zA-Z|_./+-><*]+)";        
        String retorno = this.parser(pattern, info);
        return retorno;
    }    

    
    /*
    private Integer makeAc(String info) {
        Pattern PATTERN = Pattern.compile(".*AC=([0-9\\-]+).*");
        Matcher matcher = PATTERN.matcher(info);
        if(matcher.matches() && matcher.groupCount() == 1){
            return Integer.valueOf(matcher.group(1));
        }
        return null;
    }
    */
    private String parser(String pattern, String texto){
        Pattern PATTERN = Pattern.compile(pattern);
        Matcher matcher = PATTERN.matcher(texto);
        if(matcher.matches() && matcher.groupCount() == 1){
            return matcher.group(1);
        }
        return null;
    }

    private String makeAnnotation(String ann) {
        String pattern = ".*AC=([0-9\\-]+).*";
        String retorno = this.parser(pattern, ann);
        return retorno;
    }

    
}
