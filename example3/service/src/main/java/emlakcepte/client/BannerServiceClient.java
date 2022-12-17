package emlakcepte.client;


import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@FeignClient(value ="emlakcepte-banner-service", url="{server.port}")
public class BannerServiceClient
{
	//@PostMapping(value="/banners")
	//Banner create(@RequestBody Banner banner);
	public void create(Banner banner)
	{
		String url="http://localhost:8081/banners";
		RestTemplate template=new RestTemplate();
		HttpEntity<Banner> request=new HttpEntity<>(banner);
		template.postForObject(url, request, Banner.class);

	}
}
