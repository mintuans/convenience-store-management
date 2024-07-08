/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Collection;
/**
 *
 * @author Admin
 */
import java.util.HashSet;

public class ItemSet {
    private List<Integer> items;
    private double support;

    public ItemSet() {
        this.items = new ArrayList<>();
    }

    public ItemSet(List<Integer> items) {
        this.items = items;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void addItem(Integer item) {
        items.add(item);
    }

    public void addItems(List<Integer> items) {
        this.items.addAll(items);
    }

    public int size() {
        return items.size();
    }

    public double getSupport() {
        return support;
    }

    public void setSupport(double support) {
        this.support = support;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSet itemSet = (ItemSet) o;
        return Objects.equals(items, itemSet.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
