/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 *
 * @author Admin
 */

public class AprioriAlgorithm {
    private static final double DEFAULT_MIN_SUPPORT = 0.8;

    private List<Transaction> transactions;
    private double minSupport;

    public AprioriAlgorithm(List<Transaction> transactions) {
        this(transactions, DEFAULT_MIN_SUPPORT);
    }

    public AprioriAlgorithm(List<Transaction> transactions, double minSupport) {
        this.transactions = transactions;
        this.minSupport = minSupport;
    }

    public List<ItemSet> findFrequentItemSets() {
        List<ItemSet> frequentItemSets = new ArrayList<>();
        Map<Integer, Integer> itemCount = new HashMap<>();

        // Đếm số lượng mỗi mặt hàng
        for (Transaction transaction : transactions) {
            for (Integer item : transaction.getItems()) {
                itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
            }
        }

        // Tìm tập hợp mặt hàng phổ biến ban đầu
        for (Map.Entry<Integer, Integer> entry : itemCount.entrySet()) {
            if ((entry.getValue() / (double) transactions.size()) >= minSupport) {
                ItemSet itemSet = new ItemSet();
                itemSet.addItem(entry.getKey());
                itemSet.setSupport(entry.getValue() / (double) transactions.size());
                frequentItemSets.add(itemSet);
            }
        }

        boolean hasMoreFrequentItemSets = true;
        while (hasMoreFrequentItemSets) {
            Set<ItemSet> candidateItemSets = generateCandidateItemSets(new HashSet<>(frequentItemSets));
            Map<ItemSet, Integer> candidateItemCount = new HashMap<>();

            // Đếm số lần xuất hiện của các tập hợp mặt hàng ứng viên
            for (Transaction transaction : transactions) {
                for (ItemSet candidateItemSet : candidateItemSets) {
                    if (transaction.getItems().containsAll(candidateItemSet.getItems())) {
                        candidateItemCount.put(candidateItemSet, candidateItemCount.getOrDefault(candidateItemSet, 0) + 1);
                    }
                }
            }

            // Lọc ra các tập hợp mặt hàng phổ biến mới
            frequentItemSets.clear();
            for (Map.Entry<ItemSet, Integer> entry : candidateItemCount.entrySet()) {
                if ((entry.getValue() / (double) transactions.size()) >= minSupport) {
                    entry.getKey().setSupport(entry.getValue() / (double) transactions.size());
                    frequentItemSets.add(entry.getKey());
                }
            }

            hasMoreFrequentItemSets = !frequentItemSets.isEmpty();
        }

        return frequentItemSets;
    }

    private Set<ItemSet> generateCandidateItemSets(Set<ItemSet> frequentItemSets) {
        Set<ItemSet> candidateItemSets = new HashSet<>();
        List<ItemSet> frequentList = new ArrayList<>(frequentItemSets);
        int size = frequentList.size();

        // Tạo các tập ứng viên mới từ các tập phổ biến hiện tại
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                ItemSet firstItemSet = frequentList.get(i);
                ItemSet secondItemSet = frequentList.get(j);

                ItemSet candidateItemSet = new ItemSet();
                candidateItemSet.addItems(firstItemSet.getItems());
                candidateItemSet.addItems(secondItemSet.getItems());

                if (candidateItemSet.size() == firstItemSet.size() + 1) {
                    candidateItemSets.add(candidateItemSet);
                }
            }
        }

        return candidateItemSets;
    }
}
