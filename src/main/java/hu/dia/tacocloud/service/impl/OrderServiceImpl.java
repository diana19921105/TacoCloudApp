package hu.dia.tacocloud.service.impl;

import hu.dia.tacocloud.model.data.Order;
import hu.dia.tacocloud.repository.OrderRepository;
import hu.dia.tacocloud.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
