import { Component, Input, OnInit } from '@angular/core';
import {MatAnchor, MatIconButton} from "@angular/material/button";
import {MatListItem, MatNavList} from "@angular/material/list";
import {NgScrollbar} from "ngx-scrollbar";
import {MatSidenav, MatSidenavContainer} from "@angular/material/sidenav";
import {MatToolbar} from "@angular/material/toolbar";
import {CommonModule, NgClass} from "@angular/common";
import {MatIcon} from "@angular/material/icon";
import {MatFormField} from "@angular/material/form-field";
import {MatMenu, MatMenuTrigger} from "@angular/material/menu";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  standalone: true,
  imports: [
    MatAnchor,
    MatNavList,
    NgScrollbar,
    MatSidenavContainer,
    MatListItem,
    MatToolbar,
    NgClass,
    MatIcon,
    CommonModule,
    MatIconButton,
    MatSidenav,
    MatFormField,
    MatMenuTrigger,
    MatMenu,
    MatInput

  ],
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent implements OnInit {

  isExpanded = true;
  showSubmenu: boolean = false;
  isShowing = false;
  showSubSubMenu: boolean = false;
  ngOnInit(): void { }

  mouseenter() {
    if (!this.isExpanded) {
      this.isShowing = true;
    }
  }
  mouseleave() {
    if (!this.isExpanded) {
      this.isShowing = false;
    }
  }
}
