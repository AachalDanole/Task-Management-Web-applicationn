import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{




  buses: Bus[] = [];
  travelsName: string="";
  
 source : string = "";

 destination : string ="";
  pageNo: number = 1;
  count: number = 5;
  selectedSearchType: string="";

  constructor(private busService: BusService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBus();
  }

  private getBus(){
    this.busService.getBusList().subscribe(data => {
      this.buses = data;

      //int num[]
      //int num1[]
      //num = num1
    });
  }

  busDetails(busId: number){
    this.router.navigate(['bus-details', busId]);
  }

  updateBus(busId: number){
    this.router.navigate(['update-bus', busId]);
  }

  deleteBus(busId: number){
    console.log(busId)
    this.busService.deleteBusDetailsById(busId).subscribe( data => {
      console.log(data);
      this.getBus();
    })
  }


  deleteAllBusDetails() : void{
    var status = confirm("Are you sure to See this record?");
    if (status == true) {
      this.busService.toDeleteAllBusDetails().subscribe(details => {
        console.log("i am here");
        console.log(details);
        this.getBus();
      },
        error => {
          console.log("i am error");
          console.log(error);
        })
    }
    else{
    this.getBus();
  }
  }

  searchtravelsName() : any{
    this.busService.findBytravelsName(this.travelsName).subscribe(details => {
      this.buses= details;
      console.log(details);
    },
      error => {
        console.log(error);
      });
  }



  getAcBus() {
    this.busService.findByAcDomain().subscribe({
      next: (bus1) => {
      console.log(bus1);
      this.buses = bus1;
    },
    error: (e) => console.error(e)
  });
  }

  getNonAcBus(){
    this.busService.findByNonAcDomain().subscribe({
      next: (bus1) => {
      console.log(bus1);
      this.buses = bus1;
    },
    error: (e) => console.error(e)
  });
  }

  getBusDetailsBySrcDest(){
    this.busService. getBusDetailsBySrcDest(this.source,this.destination).subscribe(details =>{
      console.log('Response from service:',details);
       this.buses= details;
    },
        error => {
          console.log(error);
       });
      
   }

   sortBy(sort: String): void {

    switch (sort) {
      case 'costLow':
        this.busService.sortByCost("asc","cost").subscribe(details => {
          console.log("Response from service:",details);
          this.buses=details;
        },
          error =>{
            console.log(error);
        
        });
          break;
       

      case 'costHigh':
        this.busService.sortByCost("desc","cost").subscribe(details => {
         console.log("Response from service:",details);
         this.buses=details; 
          },
        error =>{
        console.log(error);
    
    });
    
        break;

      case 'ratingLow':
        this.busService.sortByRatings("asc","rating").subscribe(details => {
          console.log("Response from service:",details);
          this.buses=details;
        },
          error =>{
            console.log(error);
        
        });
          break;
        
        
        
      case 'ratingHigh':
        this.busService.sortByRatings("desc","rating").subscribe(details => {
        console.log("Response from service:",details);
        this.buses=details;
    },
        error => {
        console.log(error);
    
    });
    
        break;
        default:
         break;
  }
}

search(selectedSearchType : string){
  if(this.selectedSearchType ==='travelsName'){
    this.searchtravelsName();
} else if(this.selectedSearchType ==='sourceDestination'){
  this.getBusDetailsBySrcDest();
}
}

getUsersByBusId(busId?: number){
  
  

  var status = confirm("Are you sure to See this record?");
  if (status == true) {
  this.router.navigate(['user-list', busId]);
  }
  else{
    this.getBus();
    }
 
  }
}





