import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapper {
    public List<Ranking> getRankings() throws IOException {
        Document doc = Jsoup.connect("https://www.numbeo.com/quality-of-life/rankings.jsp").get();

        System.out.printf("Title: %s\n", doc.title());

        Element tbody = doc.getElementsByTag("tbody").last();
        Elements rankingTRs = tbody.getElementsByTag("tr");

        List<Ranking> rankings = new ArrayList<>();
        for (Element rankingTR : rankingTRs) {
            Ranking ranking = new Ranking();

            Elements rankingTDs = rankingTR.getElementsByTag("td");
            for (int i = 0; i < rankingTDs.size(); i++) {
                switch (i) {
                    case 1:
                        ranking.setCity(rankingTDs.get(i).text());
                        break;
                    case 2:
                        ranking.setQualityOfLifeIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 3:
                        ranking.setPurchasingPowerIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 4:
                        ranking.setSafetyIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 5:
                        ranking.setHealthCareIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 6:
                        ranking.setCostOfLivingIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 7:
                        ranking.setPropertyPriceToIncomeRatio(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 8:
                        ranking.setTrafficCommuteTimeIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 9:
                        ranking.setPollutionIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                    case 10:
                        ranking.setClimateIndex(Double.valueOf(rankingTDs.get(i).text()));
                        break;
                }
            }
            rankings.add(ranking);
        }
        return rankings;
    }
}
