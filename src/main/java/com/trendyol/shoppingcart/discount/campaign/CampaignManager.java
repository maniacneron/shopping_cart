package com.trendyol.shoppingcart.discount.campaign;

import com.trendyol.shoppingcart.discount.Discountable;

import java.util.PriorityQueue;
import java.util.Set;

public class CampaignManager {

    public double applyCampaigns(Set<Discountable> items, Campaign... campaigns) {
        CampaignDiscount maxDiscountCampaign = getMaxDiscountCampaign(items, campaigns);

        return applyCampaign(maxDiscountCampaign, items);
    }

    private double applyCampaign(CampaignDiscount campaignToApply, Set<Discountable> items) {
        if (campaignToApply == null || campaignToApply.getCampaign() == null)
            return 0;
        items.stream()
                .filter(cartItem -> campaignToApply.getCampaign().isDiscountApplicable(cartItem))
                .forEach(suitableItem ->
                        suitableItem.applyDiscount(campaignToApply.getCampaign()));

        return campaignToApply.getTotalDiscount();
    }


    private CampaignDiscount getMaxDiscountCampaign(Set<Discountable> items, Campaign[] campaigns) {
        PriorityQueue<CampaignDiscount> maxDiscountCampaignQueue = new PriorityQueue<>();
        for (Campaign campaign : campaigns) {
            if (campaign != null) {
                CampaignDiscount campaignDiscount = new CampaignDiscount(campaign);
                items.stream()
                        .filter(cartItem -> campaign.isDiscountApplicable(cartItem))
                        .forEach(suitableItem ->
                                campaignDiscount.addDiscount(campaign.calculateDiscount(suitableItem.getTotalPrice()))
                        );
                maxDiscountCampaignQueue.add(campaignDiscount);
            }
        }
        return maxDiscountCampaignQueue.peek();
    }
}
