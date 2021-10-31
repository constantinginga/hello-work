using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Applications
{
    public class ApplicationData : IApplicationData
    {
        private HttpClient client;

        public IList<Application> Applications { get; private set; }

        public ApplicationData()
        {
            client = new();
            Applications = new List<Application>();
        }

        public async Task Create(Application application)
        {
            Applications.Add(application);
        }

        public async Task<IList<Application>> GetApplications()
        {
            return Applications;
        }
    }
}
