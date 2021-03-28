import { Container } from 'react-bootstrap';
import { ApolloProvider } from '@apollo/client';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import client from './client';
import PostList from './components/PostList';

function App() {

    return (
        <ApolloProvider client={client}>
            <Container>
              <Router>
                <Switch>
                    <Route path="/">
                        <PostList />
                    </Route>

                    <Route path="/view/:id">
                    </Route>

                    <Route path="/drafts">
                    </Route>

                </Switch>
      </Router>
            </Container>
        </ApolloProvider>
    );
}

export default App;
