package co.com.freesoft.datacenter;

  import org.springframework.cloud.openfeign.EnableFeignClients;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
  import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

  @EnableFeignClients
  @EnableJpaAuditing
  @EnableJpaRepositories
  @SpringBootApplication
  public class DatacenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatacenterApplication.class, args);
	}

}
  