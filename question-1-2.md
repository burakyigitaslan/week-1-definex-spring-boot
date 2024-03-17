**Java Frameworkleri ve Çözdükleri Problemler**

1. **Spring:** Spring, Inversion of Control (IoC) prensibi üzerine kuruludur ve bu sayede DI desenini destekler. DI, nesnelerin birbirine bağımlılıklarını azaltır ve bileşenler arasındaki bağımlılıkları dışarıdan yönetebilir hale getirir. Aspect Oriented Programming(AOP), Spring tarafından desteklenir ve uygulamanın çeşitli katmanlarında tekrar eden işlemleri yönetmek için kullanılır. Spring MVC, MVC mimarisi sayesinde veri modelini(model), kullanıcı arabirimini(view), iş mantığını (controller) birbirinden ayırarak uygulamanın modüler ve bakımı kolay olmasını sağlar. Spring Boot, Spring tabanlı uygulamaların hızlı ve kolay bir şekilde oluşturulmasını sağlayan bir araçtır. Otomatik yapılandırma ve standartlaştırılmış bağımlılık yönetimi gibi özelliklerle geliştirme sürecini hızlandırır.
1. **Hibernate:** Hibernate, Java uygulamalarında nesne ilişkisel eşleme (Object Relational Mapping-ORM) sağlayarak veritabanı işlemlerini kolaylaştırır. Veritabanı bağlantılarını yönetir, SQL sorgularını otomatik olarak oluşturur ve performansı artırmak için çeşitli optimizasyonlar sunar.
1. **JavaServer Faces(JSF):** Java EE standardı bir web uygulama framework'üdür. Component bazlı bir yaklaşıma sahiptir. Yeniden kullanılabilir componentlerin kullanımıyla kullanıcı arayüzlerinin oluşturulması basitleşir.
1. **Apache Struts:** Java tabanlı web uygulamaları geliştirmek için bir framework'tür. MVC (Model-View-Controller) tasarım desenine dayanır. Web uygulamalarının dinamik içeriğini oluşturmak için Servletler ve JSP teknolojilerini kullanır.

**SOA - Web Service - Restful Service - HTTP**

1. **SOA (Service Oriented Architecture):** Hizmet Odaklı Mimari(SOA), birbiriyle iletişim kurarak belirli bir işlevsellik sunan bağımsız ve yeniden kullanılabilir hizmetlerden oluşan bir yazılım mimarisidir. Karmaşık yazılım sistemlerini daha küçük ve daha yönetilebilir bileşenlere ayırmayı sağlar. Hizmetler birbirinden bağımsız olarak geliştirilir. Örneğin, bir e-ticaret web sitesi, ürün kataloğu, ödeme ve kargo yönetimi gibi farklı işlevler için ayrı hizmetler kullanabilir. Bu, değişikliklerin daha kolay yapılmasını ve hataların daha kolay çözülmesini sağlar. Hizmetler, birbirleriyle nasıl iletişim kuracaklarını belirleyen protokoller kullanır. Birden fazla uygulama tarafından yeniden kullanılabilir. Bu sayede, kod tekrarı azalır ve geliştirme süresi kısalır. SOA, yeni işlevsellik eklemeyi veya mevcut işlevselliği değiştirmeyi kolaylaştırır. Bu sayede, değişen iş ihtiyaçlarına daha hızlı cevap verilmesini mümkün kılar.
1. **Web Service:** Web servisleri, internet üzerinden birbirleriyle iletişim kurabilen yazılım uygulamalarıdır. Farklı platformlarda ve programlama dillerinde yazılmış uygulamalar arasında veri alışverişi ve işlevsellik paylaşımı imkanı sunar. Web servisleri XML, JSON gibi veri formatlarını kullanarak veri alışverişi yapar. İki tane web servis türü vardır: 
   1. **SOAP:** SOAP (Simple Object Access Protocol), web servisleri için bir standart XML tabanlı mesajlaşma protokolüdür. Veri alışverişi yapılırken XML formatı kullanılır.
   1. **REST:** REST (Representational State Transfer),** HTTP yöntemlerini (GET, POST, PUT, DELETE) kullanarak veri alışverişi gerçekleştirir. GET, bir kaynaktan veri almak için kullanılır. POST, bir kaynağa veri göndermek için kullanılır. PUT, bir kaynağın var olan verilerini güncellemek için kullanılır. DELETE, bir kaynağı silmek için kullanılır. Veri alışverişi yapılırken JSON formatı kullanılır. 

Java Spring Boot ile RESTful servis örneği:

@SpringBootApplication

public class App {

`    `public static void main(String[] args) {

`        `SpringApplication.run(App.class, args);

`    `}

}

@RestController

@RequestMapping("/users")

public class UserService {

`    `@Autowired

`    `private UserRepository userRepository;

`    `@GetMapping

`    `public List<User> getAllUsers() {

`        `return userRepository.findAll();

`    `}

`    `@PostMapping

`    `public User createUser(@RequestBody User user) {

`        `return userRepository.save(user);

`    `}

`    `@PutMapping("/{id}")

`    `public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {

`        `User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

`        `existingUser.setName(user.getName());

`        `existingUser.setEmail(user.getEmail());

`        `return userRepository.save(existingUser);

`    `}

`    `@DeleteMapping("/{id}")

`    `public void deleteUser(@PathVariable("id") Long id) {

`        `userRepository.deleteById(id);

`    `}

}


