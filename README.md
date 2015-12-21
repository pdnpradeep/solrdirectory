# solrdirectory
Solr Phone Directory with backbone routers,collection and view
In files solrdirectory directory is core directory
It has to place in your solr core directory and change solr.xml of ur solr core directory to

<cores adminPath="/admin/cores" defaultCoreName="solrdirectory" host="${host:}" hostPort="${jetty.port:8983}" hostContext="${hostContext:solr}" zkClientTimeout="${zkClientTimeout:15000}">
	 <core name="collection1" instanceDir="collection1" />
   <core name="solrdirectory" instanceDir="solrdirectory" />
</cores>

After start solr server
Run project using 
mvn tomcat7:run -Psolrstart "-DSOLR_HTTP_SERVER_URL=http://localhost:8983/solr"
