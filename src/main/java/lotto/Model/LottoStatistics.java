package lotto.Model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
    private final int purchaseAmount;

    public LottoStatistics(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        initializeResultCounts();
    }

    private void initializeResultCounts() {
        for(LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }
    }

    private void updateResultCount(LottoResult result) {
        if(result != null){
            resultCounts.put(result, resultCounts.get(result) + 1);
        }
    }
    public void processTickets(List<Lotto> allLotto, WinningLotto winningLotto){
        for(Lotto ticket : allLotto){
            LottoResult result = winningLotto.getMatchResult(ticket);
            updateResultCount(result);
        }
    }
}
