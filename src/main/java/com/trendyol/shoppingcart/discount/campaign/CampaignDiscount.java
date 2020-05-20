package com.trendyol.shoppingcart.discount.campaign;

class CampaignDiscount implements Comparable {
    Campaign campaign;
    double totalDiscount;

    public CampaignDiscount(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    public int compareTo(Object other) {
        return Double.compare(((CampaignDiscount) other).getTotalDiscount(), this.getTotalDiscount());
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void addDiscount(double discount) {
        if (discount >= 0) {
            this.totalDiscount += discount;
        }
    }
}
