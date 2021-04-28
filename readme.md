<h3> CAR LIST APP </h3>
<h6> Spring Boot et MySQL (JPA), Securisée avec Spring Security Basic Auth </h6>
<p> <strong> List des endpoints </strong> </p>
<ul>
    <li>/car : endpoint securisé (POST: ajout d'une voiture | GET : fetch de la liste de voiture avec commentaire) </li>
    <li>/car/{id} : endpoint securisé (GET only: fetch d'une voiture spécifique avec commentaire)</li>
    <li>/car/public : endpoint public (GET only: fetch de la liste de voiture sans commentaire)</li>
    <li>/car/public/{id} : endpoint public (GET only: fetch d'une voiture spécifique sans commentaire)</li>
    <li>/comments: endpoint securisé (POST: ajout d'un commentaire sur une voiture | GET: fetch de la liste des commentaires)</li>
    <li>/comments/{id}: endpoint securisé (GET only: fetch d'un commentaire spécifique)</li>
</ul>
<br/>
<h6> Elément du Car </h6>
<ul>
  <li>brand: String</li>
  <li>immatriculation: String (unique)</li>
  <li>traveledDistance: Double</li>
  <li>comments: String[]</li>
</ul>
<br/>
<h6> Elément du Comment</h6>
<ul>
  <li>carId: Long</li>
  <li>value: String</li>
</ul>
<br/>
<h6> Credentials</h6>
<ul>
  <li> username: admin</li>
  <li> password: admin<li>
</ul>