import lombok.Data;

@Data
public class Ranking {
    private String city;
    private Double qualityOfLifeIndex;
    private Double purchasingPowerIndex;
    private Double safetyIndex;
    private Double healthCareIndex;
    private Double costOfLivingIndex;
    private Double propertyPriceToIncomeRatio;
    private Double trafficCommuteTimeIndex;
    private Double pollutionIndex;
    private Double climateIndex;
}
