# Unified Template for {{name}} Project
## Prerequisites
- [rlwrap](https://github.com/hanslub42/rlwrap): Helper to allows Special interaction with the REPL (Optional)
- [Leiningen](https://leiningen.org): Tool for a peaceful Clojure(Script) environment.
- [PhantomJS](http://phantomjs.org): Javascript library for Unit Testing. Used for Frontend Unit Testing.

## Main commands
*Note*: You can add `rlwrap` in front of every command to get additional features (Backspace, history, ...)
### Generic
- `lein clean`: clean the project

### Frontend
- `lein front`: Launch frontend in dev
- `lein test-front`: Launch frontend tests
- `lein build-front`: Launch frontend build

### Backend
- `lein back`: Launch backend in dev
- `lein test-back`: Launch backend tests


## Architecture
```
├── project.clj ----------------------> Project
├── README.md ------------------------> The file you're currently reading
├── test.sh --------------------------> Test Script for CI/CD
├── .travis.yml ----------------------> TravisCI configuration file
├── dev
│   └── {{sanitized}}
│       └── dev
│           ├── test_runner.cljs -----> Frontend Test Runner
│           └── core.cljs ------------> Frontend Main File (for devcards build)
├── resources
│   └── public
│       ├── css
│       │   └── style.css ------------> Main Stylesheet
│       ├── cards.html ---------------> HTML Main File (for devcards build)
│       └── index.html ---------------> HTML Main File (for dev/prod build)
├── src
│   ├── back
│   │   └── {{sanitized}}
│   │       └── core.clj -------------> Backend Main File
│   ├── common
│   │   └── {{sanitized}}
│   │       └── common
│   │           └── core.cljc --------> Common example file
│   └── front
│       └── {{sanitized}}
│           └── core.cljs ------------> Frontend Main File
└── test
    ├── back
    │   └── test
    │       └── core.clj -------------> Backend Main Test
    ├── common
    │   └── test
    │       └── common
    │           └── core.cljc --------> Common Main Test
    └── front
        └── test
            └── core.cljs ------------> Frontend Main Test
```
