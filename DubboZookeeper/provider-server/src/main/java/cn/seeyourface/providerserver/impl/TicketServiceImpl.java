package cn.seeyourface.providerserver.impl;

import cn.seeyourface.providerserver.services.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService //一启动就能被扫描到，自动注册到注册中心
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "购票成功！";
    }
}
