package cn.seeyourface.providerserver.impl;

import cn.seeyourface.providerserver.services.TicketService;

public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "购票成功！";
    }
}
