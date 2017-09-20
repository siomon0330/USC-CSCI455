/*  Name:Chuanli Wei
 *  USC NetID:6222006323
 *  CS 455 Spring 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int lastIndexOf(ListType list, int val) {
    if(list == NULL){
        return -1;
    }
    //index is the index of the val
    //flag is the index of the every entry that we are traversing
    int index = -1;
    int flag = -1;
    while(list != NULL){

        //increment the flag in every iteration
        flag++;
        int number = list -> data;

        //every time we meet the val, we update the index that we find
        if(number == val){
            index = flag;
        }
        list = list -> next;
    }
    return index;
}



void removeFollowingEvens(ListType &list) {
    ListType head = list;
    if(list == NULL){
        return;
    }
    //we create a previous pointer which points to the element just visited
    ListType  pre = NULL;
    while(head != NULL){
        pre = head;
        head = head -> next;
        if(pre -> data % 2 == 0){
            while(head != NULL && head -> data % 2 == 0){
                //delete the even element
                pre -> next = head -> next;
                head = head -> next;
            }

        }

    }

}



void mirrorList(ListType & list) {
    if(list == NULL){
        return;
    }
    ListType  head = list;
    //the new list is to store the mirror elements
    ListType  newList = NULL;
    insertFront(newList, head-> data);
    while(head->next != NULL){
        int  num = head ->next -> data;
        insertFront(newList, num);
        head = head -> next;
    }
    //attach the two list
    head -> next = newList;

}



void rotateRight(ListType &list, int k) {

    if(list == NULL || k <= 0){
        return;
    }

    //first get the length of the list
    ListType head = list;
    int length = 0;
    while(head!=NULL){
        length++;
        head = head -> next;
    }
    if(k >= length){
        return;
    }

    head = list;
    //flag is the position that rotate the list
    int flag = length - k;
    int index = 0;
    while(head != NULL){
        index++;
        if(index == flag){
            ListType node = head;
            while(head -> next != NULL){
                head = head -> next;
            }
            //attach the head of the original list
            head ->next  = list;
            list = node -> next;
            node->next =NULL;
            break;
        }
        head = head->next;
    }
}

























