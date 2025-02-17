package q1079;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Set<String> permutationSet;
    private int maxLength;
    private Map<String, Integer> valuesMap;

    Solution() {
        this.permutationSet = new HashSet<String>();
        this.valuesMap = new HashMap<String, Integer>();
    }

    private void logic(String currentPermutation) {
        if (currentPermutation.length() > 0) {
            this.permutationSet.add(currentPermutation);
        }
        if (currentPermutation.length() == this.maxLength) {
            return;
        }

        for (String value : this.valuesMap.keySet()) {
            if (this.valuesMap.get(value) == 0) {
                continue;
            }

            int valueCount = this.valuesMap.get(value);
            this.valuesMap.put(value, valueCount - 1);
            this.logic(currentPermutation + value);
            this.valuesMap.put(value, valueCount);
        }
    }

    public int numTilePossibilities(String tiles) {
        this.maxLength = tiles.length();

        for (int idx = 0; idx < tiles.length(); idx += 1) {
            String tile = tiles.substring(idx, idx + 1);

            if (!this.valuesMap.containsKey(tile)) {
                this.valuesMap.put(tile, 0);
            }

            int existingCount = this.valuesMap.get(tile);
            this.valuesMap.put(tile, existingCount + 1);
        }

        this.logic("");
        return this.permutationSet.size();
    }
}