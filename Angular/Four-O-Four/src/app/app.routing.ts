import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { UserInfoComponent} from './user-info';
import { CartComponent } from './cart';
import { SellComponent } from './sell';


const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'user', component: UserInfoComponent },
    { path: 'cart', component: CartComponent },
    { path: 'Sell', component: SellComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);