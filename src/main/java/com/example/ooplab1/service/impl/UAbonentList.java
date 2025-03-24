package com.example.ooplab1.service.impl;

import com.example.ooplab1.model.UAbonent;
import com.example.ooplab1.service.UAbonementService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class UAbonentList implements UAbonementService {
    public final List<UAbonent> abonentList;

    public UAbonentList() {
        abonentList = new ArrayList<>();
    }

    public List<UAbonent> findAll(){
        return abonentList;
    }

    public List<UAbonent> findAll(String name, String phone){
        List<UAbonent> result = new ArrayList<>();
        if (name == null) {
            name = "";
        }
        if (phone == null) {
            phone = "";
        }
        for (UAbonent contact : findAll()) {
            boolean matchesName = contact.getName().toLowerCase().startsWith(name.toLowerCase());
            boolean matchesPhone = contact.getPhone().startsWith(phone);

            if (matchesName && matchesPhone) {
                result.add(contact);
            }
        }
        return result;
    }

    public UAbonent findAbonent(UAbonent abonent){
        return abonentList.stream().filter(a -> a.equals(abonent)).findFirst().orElse(null);
    }

    private void sort(){
        abonentList.sort(new Comparator<UAbonent>() {
            @Override
            public int compare(UAbonent a1, UAbonent a2) {
                return a1.Less(a2);
            }
        });
    }

    public void add(UAbonent uAbonent) {
        abonentList.add(uAbonent);
        sort();
    }

    public Integer count() {
        return abonentList.size();
    }

    public String getName(Integer index) {
        return abonentList.get(index).getName();
    }

    public String getNumber(Integer index) {
        return abonentList.get(index).getPhone();
    }

    public void clear(){
        abonentList.clear();
    }

    public void remove(Integer index){
        abonentList.remove(index);
    }

    public void remove(UAbonent abonent){
        abonentList.removeIf(uAbonent -> uAbonent.equals(abonent));
    }

    public UAbonent update(UAbonent old, UAbonent newUAbonent){
        final UAbonent uAbonent = findAbonent(old);
        uAbonent.setName(newUAbonent.getName());
        uAbonent.setPhone(newUAbonent.getPhone());
        sort();
        return uAbonent;
    }

}
