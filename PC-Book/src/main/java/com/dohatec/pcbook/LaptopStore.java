package com.dohatec.pcbook;

import com.dohatec.Filter;
import com.dohatec.Laptop;
import io.grpc.Context;

public interface LaptopStore {
    void Save(Laptop laptop) throws Exception;
    Laptop Find(String id);
    void Search(Context ctx, Filter filter, LaptopStream stream);
}
