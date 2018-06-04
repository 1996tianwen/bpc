package com.wtw.bpc.service;


import com.sun.corba.se.impl.orb.ORBConfiguratorImpl;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.CatalogFactory;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ChainService {
    private static final Logger logger = LoggerFactory.getLogger(ChainService.class);
    private Catalog catalog;
    private Command command;

    public static void loadCatalogFile(String cfgFile) throws Exception {
        logger.info("cfgFile : { }" + cfgFile);
        ConfigParser parser = new ConfigParser();
        parser.parse(ChainService.class.getClassLoader().getResource(cfgFile));
    }

    public void execute(String name, Context context) throws Exception {
        String[] nameAttr = name.split(":");
        String catalogName = nameAttr[0];
        String commandName = nameAttr[1];
        catalog = CatalogFactory.getInstance().getCatalog(catalogName);
        command = catalog.getCommand(commandName);
        command.execute(context);
    }
}
