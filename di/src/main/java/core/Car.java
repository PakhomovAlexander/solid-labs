package core;

import org.springframework.stereotype.Service;

@Service
public interface Car {
    void go2Point(int km);

    void fill(double gas);
}
