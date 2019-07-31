package com.pingpong.module;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrap;
import netflix.karyon.jersey.blocking.KaryonJerseyModule;

import com.netflix.governator.annotations.Modules;


@ArchaiusBootstrap
@KaryonBootstrap(name = "pingpong-service")
@Modules(include = {
        ShutdownModule.class, 
        KaryonWebAdminModule.class,
        BootstrapInjectionModule.KaryonJerseyRouterModuleImpl.class,
})
public interface BootstrapInjectionModule {

	class KaryonJerseyRouterModuleImpl extends KaryonJerseyModule {
		@Override
		protected void configureServer() {
            server().port(8888).threadPoolSize(100);
		}
	}
}
