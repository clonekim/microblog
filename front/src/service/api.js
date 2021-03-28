import { useQuery } from '@apollo/client';


import GET_POSTS from '../graphql/query/posts.graphql';
//import ADD_POST from '../graphql/mutation/post.graphql'


const list= async page => {
  return await useQuery(GET_POSTS(page));
};

const add = post => {
}


export default {
  list
}
