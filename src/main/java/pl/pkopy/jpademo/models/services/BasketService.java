package pl.pkopy.jpademo.models.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.pkopy.jpademo.models.BarcodeEntity;
import pl.pkopy.jpademo.models.forms.BarcodeForm;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketService {
    private List<BarcodeEntity> barcodeEntityList;

    public BasketService() {
        barcodeEntityList = new ArrayList<>();

    }

    public List<BarcodeEntity> getBarcodeEntityList() {
        return barcodeEntityList;
    }

    public void setBarcodeEntityList(List<BarcodeEntity> barcodeEntityList) {
        this.barcodeEntityList = barcodeEntityList;
    }

    public int basketLength() {
        return barcodeEntityList.size();
    }

    public void addProductToBasket(BarcodeEntity barcodeEntity){
        barcodeEntityList.add(barcodeEntity);
    }

    public void removeProductFromBasket(BarcodeEntity barcodeEntity){
        barcodeEntityList.remove(barcodeEntity);
    }
}
