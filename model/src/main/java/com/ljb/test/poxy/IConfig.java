package com.ljb.test.poxy;

import com.ljb.test.annotation.Property;

public interface IConfig {
    
    @Property("db.url")
    String url();

    @Property("db.userName")
    String user();

    @Property("db.password")
    String password();

    @Property("db.driveName")
    String drivePath();
}
